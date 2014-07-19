public class Item {
    private String name;
    private int quantity;

    public Item(int quantity, String name) {
        this.quantity = quantity;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return quantity;
    }
}
