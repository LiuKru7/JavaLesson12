package tasks.grocery_list_manager_v1;

public class GroceryItem {
    String name;
    int quantity;
    double pricePerUnit;

    public GroceryItem(String name, int quantity, double pricePerUnit) {
        this.name = name;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }
}

