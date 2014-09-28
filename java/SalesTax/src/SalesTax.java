import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class SalesTax {
    private BigDecimal importTaxRate;
    private List<String> exemptGoods;
    private BigDecimal basicSalesTaxRate;
    private static int SCALE = 2;

    public SalesTax(BigDecimal basicSalesTaxRate, List<String> exemptGoods, BigDecimal importTaxRate){
        this.exemptGoods = exemptGoods;
        this.basicSalesTaxRate = basicSalesTaxRate;
        this.importTaxRate = importTaxRate;
    }

    public BigDecimal getBasicSalesTax(InputLine inputLine){
        for (String exemptGood : exemptGoods){
            if(inputLine.getName().contains(exemptGood)){
                return new BigDecimal("0.00");
            }
        }

        BigDecimal basicSalesTax = basicSalesTaxRate.multiply(inputLine.getPrice());
        return getRoundedValue(basicSalesTax);
    }

    public BigDecimal getRoundedValue(BigDecimal tax) {
        BigDecimal roundFactor = new BigDecimal(0.05);
        BigDecimal[] factorAndRemainder = tax.divideAndRemainder(roundFactor);
        BigDecimal divisionFactor = factorAndRemainder[0];
        BigDecimal remainder = factorAndRemainder[1];
        BigDecimal result = divisionFactor.multiply(roundFactor);
        if ( remainder.compareTo(BigDecimal.ZERO) == 1 ){
            result = result.add(roundFactor);
        }
        return result.setScale(SCALE, RoundingMode.HALF_UP);
    }

    public BigDecimal getImportDuty(InputLine inputLine) {
        if(inputLine.getName().contains("imported")){
            BigDecimal importTax = importTaxRate.multiply(inputLine.getPrice());
            return getRoundedValue(importTax);
        }
        return new BigDecimal("0.00");
    }

    public BigDecimal getSalesTax(InputLine inputLine) {
        BigDecimal basicSalesTax = getBasicSalesTax(inputLine);
        BigDecimal importDuty = getImportDuty(inputLine);
        return basicSalesTax.add(importDuty);
    }

    public BigDecimal getSalesTax(List<InputLine> items) {
        BigDecimal salesTax = new BigDecimal("0.00");
        for (InputLine item : items){
            salesTax = salesTax.add(getSalesTax(item));
        }
        return salesTax;
    }

    public BigDecimal getShelfPrice(InputLine item) {
        BigDecimal salesTax = getSalesTax(item);
        return item.getPrice().add(salesTax);
    }

    public BigDecimal getPriceWithTax(List<InputLine> items) {
        BigDecimal total = new BigDecimal("0.00");
        for (InputLine item : items){
            total = total.add(item.getPrice());
        }
        return total;
    }
}
