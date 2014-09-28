import java.math.BigDecimal;
import java.util.List;

public class SalesTax {
    private BigDecimal importTax;
    private List<String> exemptGoods;
    private BigDecimal basicSalesTax;

    public SalesTax(BigDecimal basicSalesTax, List<String> exemptGoods, BigDecimal importTax){
        this.exemptGoods = exemptGoods;
        this.basicSalesTax = basicSalesTax;
        this.importTax = importTax;
    }

    public BigDecimal getBasicSalesTax(InputLine inputLine){
        for (String exemptGood : exemptGoods){
            if(inputLine.getName().contains(exemptGood)){
                return new BigDecimal("0.00");
            }
        }
        return basicSalesTax.multiply(inputLine.getPrice());
    }

    public BigDecimal getImportDuty(InputLine inputLine) {
        if(inputLine.getName().contains("imported")){
            return importTax.multiply(inputLine.getPrice());
        }
        return new BigDecimal("0.00");
    }

    public BigDecimal getSalesTax(InputLine inputLine) {
        return getBasicSalesTax(inputLine).add(getImportDuty(inputLine));
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
