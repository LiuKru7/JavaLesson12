package tasks.grocery_list_manager;

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
        System.out.println("\nGrocery items list:");
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d.Name: %s; Quantity: %d; Price per unit %.2f eur.;%n",
                    i+1, items.get(i).name , items.get(i).quantity, items.get(i).pricePerUnit);
        }
    }


    public void calculateTotalCost () {
        System.out.println("\nGrocery items list with total cost:  ");
        for (int i = 0; i < items.size(); i++) {
            double totalPrice = items.get(i).quantity * items.get(i).pricePerUnit;
            System.out.printf("%d.Name: %s; Quantity: %d; Price per unit %.2f eur.; Total Price : %.2f eur. %n",
                    i+1, items.get(i).name , items.get(i).quantity, items.get(i).pricePerUnit, totalPrice);

        }
    }
    public void buyItem () {
        printList();
        System.out.println("\nWrite number that item you wanna buy: ");
        int itemNumber = scanner.nextInt();
        int itemIndex = itemNumber-1;

        System.out.println("How much: ");
        int itemQuantity = scanner.nextInt();

        if (itemNumber<1 || itemNumber>items.size()){
            System.out.println("This item not exist ");
            return;
        }
        if (itemQuantity > items.get(itemIndex).quantity) {
            System.out.println("not enought quantity ");
            return;
        }
        double totalCost = items.get(itemIndex).pricePerUnit * itemQuantity;
        String yourItem = items.get(itemIndex).name;

        if (itemQuantity == items.get(itemIndex).quantity) {
            items.remove(itemIndex);
        } else {
            items.get(itemIndex).quantity -= itemQuantity;
        }

        System.out.printf("You buy item: %s, quantity: %d, and you pay %.2f euros.", yourItem, itemQuantity, totalCost);
    }
}
