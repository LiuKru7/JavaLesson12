package tasks.grocery_list_manager;

public class GroceryItem {
    public String name;
    public int quantity;
    public double pricePerUnit;

    public GroceryItem(String name, int quantity, double pricePerUnit) {
        this.name = name;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }
}

