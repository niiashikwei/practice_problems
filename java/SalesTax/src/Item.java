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
}
