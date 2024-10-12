package tasks.grocery_list_manager_v1;

import java.util.Scanner;

public class GroceryList {
    private final GroceryItem[] items = new GroceryItem[5];
    private final Scanner scanner = new Scanner(System.in);

    public void addItem() {
        System.out.print("Enter the item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();
        while (quantity<1) {
            System.out.println("Quantity cannot be zero or negative. Please enter a valid quantity:");
            quantity = scanner.nextInt();
        }
        System.out.print("Enter the price per unit: ");
        double pricePerUnit = scanner.nextDouble();
        while (pricePerUnit<=0) {
            System.out.println("Price per unit cannot be zero or negative. Please enter a valid price: ");
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
        System.out.println("No available slot for a new item.");

    }
    public void printList() {
        System.out.println("\nGrocery list:");
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
