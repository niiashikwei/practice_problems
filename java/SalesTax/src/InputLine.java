import java.math.BigDecimal;

public class InputLine {
    private String name;
    private int quantity;
    private BigDecimal price;

    public InputLine(int quantity, String name, BigDecimal itemPrice) {
        this.quantity = quantity;
        this.name = name;
        this.price = itemPrice;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InputLine inputLine = (InputLine) o;

        if (quantity != inputLine.quantity) return false;
        if (name != null ? !name.equals(inputLine.name) : inputLine.name != null) return false;
        if (price != null ? !price.equals(inputLine.price) : inputLine.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + quantity;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
