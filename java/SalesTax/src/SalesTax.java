import java.util.List;

public class SalesTax {
    private double importTax;
    private List<String> exemptGoods;
    private double basicSalesTax;

    public SalesTax(double basicSalesTax, List<String> exemptGoods, double importTax){
        this.exemptGoods = exemptGoods;
        this.basicSalesTax = basicSalesTax;
        this.importTax = importTax;
    }

    public double getBasicSalesTax(InputLine inputLine){
        for (String exemptGood : exemptGoods){
            if(inputLine.getName().contains(exemptGood)){
                return 0.0;
            }
        }
        return basicSalesTax * inputLine.getPrice();
    }

    public double getImportDuty(InputLine inputLine) {
        if(inputLine.getName().contains("imported")){
            return importTax * inputLine.getPrice();
        }
        return 0.0;
    }

    public double getTotalSalesTax(InputLine inputLine) {
        return getBasicSalesTax(inputLine) + getImportDuty(inputLine);
    }

    public double getTotalSalesTax(List<InputLine> items) {
        double salesTax = 0;
        for (InputLine item : items){
            salesTax += getTotalSalesTax(item);
        }
        return salesTax;
    }
}
