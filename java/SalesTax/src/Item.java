public class Item {
    private String name;
    private int quantity;
    private double price;

    public Item(int quantity, String name, double itemPrice) {
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

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (Double.compare(item.price, price) != 0) return false;
        if (quantity != item.quantity) return false;
        if (!name.equals(item.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + quantity;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

}
