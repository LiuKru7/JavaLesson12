package tasks.grocery_list_manager;

import java.util.ArrayList;
import java.util.Scanner;

public class GroceryList {
    private final ArrayList<GroceryItem> items;
    private final Scanner scanner = new Scanner(System.in);

    public GroceryList() {
        this.items = new ArrayList<>();
    }

    public void addItem() {
        System.out.print("Enter item name: ");
        String name = this.scanner.nextLine();
        System.out.print("Enter item quantity: ");
        int quantity = this.scanner.nextInt();
        while (quantity<1) {
            System.out.println("Quantity can be zero or negative");
            quantity = this.scanner.nextInt();
        }
        System.out.print("Enter item price per unit: ");
        double pricePerUnit = this.scanner.nextDouble();
        while (pricePerUnit<=0) {
            System.out.println("Enter price per unit can't be zero or negative");
            pricePerUnit = this.scanner.nextDouble();
        }
        scanner.nextLine();
        GroceryItem groceryItem = new GroceryItem(name, quantity, pricePerUnit);
        this.items.add(groceryItem);
    }
    public void printList() {
        System.out.println("\nGrocery list:");
        for (int i = 0; i < this.items.size(); i++) {
            System.out.printf("%d.Name: %s; Quantity: %d; Price per unit %.2f eur.;%n",
                    i+1, this.items.get(i).name , this.items.get(i).quantity, this.items.get(i).pricePerUnit);
        }
    }


    public void calculateTotalCost () {
        System.out.println("\nGrocery items list with total cost:  ");
        for (int i = 0; i < this.items.size(); i++) {
            double totalPrice = this.items.get(i).quantity * this.items.get(i).pricePerUnit;
            System.out.printf("%d.Name: %s; Quantity: %d; Price per unit %.2f eur.; Total Price : %.2f eur. %n",
                    i+1, this.items.get(i).name , this.items.get(i).quantity, this.items.get(i).pricePerUnit, totalPrice);

        }
    }
    public void buyItem () {
        printList();
        System.out.println("\nEnter the number of the item you want to buy: ");
        int itemNumber = this.scanner.nextInt();
        int itemIndex = itemNumber-1;

        System.out.println("Enter the quantity you want to buy: ");
        int itemQuantity = this.scanner.nextInt();

        if (itemNumber<1 || itemNumber>items.size()){
            System.out.println("This item not exist ");
            return;
        }
        if (itemQuantity > this.items.get(itemIndex).quantity) {
            System.out.println("Not enough quantity available.");
            return;
        }
        double totalCost = this.items.get(itemIndex).pricePerUnit * itemQuantity;
        String yourItem = this.items.get(itemIndex).name;

        if (itemQuantity == this.items.get(itemIndex).quantity) {
            this.items.remove(itemIndex);
        } else {
            this.items.get(itemIndex).quantity -= itemQuantity;
        }

        System.out.printf("You bought: %s, quantity: %d, and you pay %.2f euros.", yourItem, itemQuantity, totalCost);
    }
}
