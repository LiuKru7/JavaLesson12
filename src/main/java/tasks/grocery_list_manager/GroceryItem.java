package tasks.grocery_list_manager;

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

//Exercise 1: "Grocery List Manager"
//Objective: Practice constructors, composition, arrays, for loops, and conditionals with a basic task manager for grocery items.
//Problem Description:
//You are tasked with creating a simple Grocery List Manager. Each item on the list is represented by a GroceryItem class, and the list is managed by a GroceryList class.
//Classes:
//GroceryItem:
//Attributes: name (String), quantity (int), pricePerUnit (double).
//Constructor to initialize the name, quantity, and price per unit.
//GroceryList:
//Attributes: an array of GroceryItem objects (with a maximum size of 10 items).
//Constructor to initialize the list.
//        Method addItem(GroceryItem item) to add items to the list.
//Method calculateTotalCost() to calculate and return the total cost of all items in the list.
//        Method printList() to print all items, their quantities, and total costs.
//Task:
//Use a Scanner to allow the user to input item details (name, quantity, and pricePerUnit) and add items to the grocery list.
//After the list is populated, print each item in the list and its total cost (quantity * pricePerUnit).
//Display the total cost for all items combined.
//If the list exceeds 10 items, print a message stating that the list is full and stop adding more items.
//Requirements:
//Use an array to store GroceryItem objects.
//Implement a for loop to iterate over the array to display items and calculate the total cost.
//Use if/else conditions to check when the list is full.