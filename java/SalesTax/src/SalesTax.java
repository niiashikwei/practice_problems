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
        if (!exemptGoods.contains(inputLine.getName())){
            return basicSalesTax * inputLine.getPrice();
        }
        return 0.0;
    }

    public double getImportDuty(InputLine inputLine) {
        if(inputLine.getName().contains("imported")){
            return importTax * inputLine.getPrice();
        }
        return 0.0;
    }
}
