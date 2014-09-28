import java.math.BigDecimal;
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
            stringBuilder.append(String.format("%s %s: %.2f\n", item.getQuantity(), item.getName(), salesTax.getShelfPrice(item)));
        }
        stringBuilder.append(String.format("Sales Taxes: %.2f\n", getSalesTaxTotal()))
                     .append(String.format("Total: %.2f\n\n", getPricesTotal().add(getSalesTaxTotal())));

        return stringBuilder.toString();
    }

    private BigDecimal getPricesTotal() {
        return salesTax.getPriceWithTax(items);
    }

    private BigDecimal getSalesTaxTotal() {
        return salesTax.getSalesTax(items);
    }
}
