package tasks.grocery_list_manager_v1;

import java.util.Scanner;

public class GroceryList {
    private final GroceryItem[] items = new GroceryItem[5];
    private final Scanner scanner = new Scanner(System.in);

    public void addItem() {
        System.out.print("Write item name: ");
        String name = scanner.nextLine();
        System.out.print("Write item quantity: ");
        int quantity = scanner.nextInt();
        while (quantity<1) {
            System.out.println("Item quantity can be zero or negative");
            quantity = scanner.nextInt();
        }
        System.out.print("Write item price per unit: ");
        double pricePerUnit = scanner.nextDouble();
        while (pricePerUnit<=0) {
            System.out.println("Item price per unit can't be zero or negative");
            pricePerUnit = scanner.nextDouble();
        }
        scanner.nextLine();
        GroceryItem groceryItem = new GroceryItem(name, quantity, pricePerUnit);
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = groceryItem;
                return;
            }
        }
        System.out.println("not empty slot for new item");

    }
    public void printList() {
        System.out.println("\nGrocery items list:");
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                return;
            }
            System.out.printf("%d.Name: %s; Quantity: %d; Price per unit %.2f eur.;%n",
                    i+1, items[i].name , items[i].quantity, items[i].pricePerUnit);
        }
    }
    public void calculateTotalCost () {
        System.out.println("\nGrocery items list with total cost:  ");
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                return;
            }
            double totalPrice = items[i].quantity * items[i].pricePerUnit;
            System.out.printf("%d.Name: %s; Quantity: %d; Price per unit %.2f eur.; Total Price : %.2f eur. %n",
                    i+1, items[i].name , items[i].quantity, items[i].pricePerUnit, totalPrice);

        }
    }
}
