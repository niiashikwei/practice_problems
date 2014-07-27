import java.util.List;

public class Receipt {
    private final List<InputLine> items;
    private final SalesTax salesTax;

    public Receipt(List<InputLine> items, SalesTax salesTax) {
        this.items = items;
        this.salesTax = salesTax;
    }

    public String buildReceipt(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Output: %s\n", i+1));
        for(InputLine item : items){
            stringBuilder.append(String.format("%s %s: %.2f\n", item.getQuantity(), item.getName(), salesTax.getPriceWithTax(item)));
        }
        stringBuilder.append(String.format("Sales Taxes: %.2f\n", getSalesTaxTotal()))
                     .append(String.format("Total: %.2f\n\n", getPricesTotal() + getSalesTaxTotal()));

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
