package tasks.grocery_list_manager_v1;

public class GroceryMain {
    public static void main(String[] args) {
        GroceryList groceryList = new GroceryList();
        groceryList.addItem();
        groceryList.addItem();
        groceryList.printList();
        groceryList.calculateTotalCost();

    }
}
