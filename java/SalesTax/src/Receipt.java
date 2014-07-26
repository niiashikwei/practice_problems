import java.util.List;

public class Receipt {
    private final List<InputLine> items;
    private final SalesTax salesTax;

    public Receipt(List<InputLine> items, SalesTax salesTax) {
        this.items = items;
        this.salesTax = salesTax;
    }

    public String buildReceipt() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Output:")
                     .append("\n");
        for(InputLine item : items){
            stringBuilder.append(String.format("%s %s: %.2f\n", item.getQuantity(), item.getName(), item.getPrice()));
        }
        stringBuilder.append(String.format("Sales Taxes: %.2f\n", getSalesTaxTotal()))
                     .append(String.format("Total: %.2f", getPricesTotal() + getSalesTaxTotal()));

        return stringBuilder.toString();
    }

    private double getPricesTotal() {
        double total = 0;
        for (InputLine item : items){
            total += item.getPrice();
        }
        return total;
    }

    private double getSalesTaxTotal() {
        return salesTax.getTotalSalesTax(items);
    }
}
