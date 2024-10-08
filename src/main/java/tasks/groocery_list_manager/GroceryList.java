package tasks.groocery_list_manager;

import java.util.ArrayList;
import java.util.Scanner;

public class GroceryList {
    private final ArrayList<GroceryItem> items;
    private final Scanner scanner = new Scanner(System.in);

    public GroceryList() {
        items = new ArrayList<>();
    }

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
        items.add(groceryItem);

    }
    public void printList() {
        System.out.println("Grocery items list:");
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d.Name: %s; Quantity: %d; Price per unit %.2f eur.;%n",
                    i+1, items.get(i).name , items.get(i).quantity, items.get(i).pricePerUnit);
        }
    }


    public void calculateTotalCost () {
        System.out.println("Grocery items list with total cost:  ");
        for (int i = 0; i < items.size(); i++) {
            double totalPrice = items.get(i).quantity * items.get(i).pricePerUnit;
            System.out.printf("%d.Name: %s; Quantity: %d; Price per unit %.2f eur.; Total Price : %.2f eur. %n",
                    i+1, items.get(i).name , items.get(i).quantity, items.get(i).pricePerUnit, totalPrice);

        }
    }

}
