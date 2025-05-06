//Write a program to create a telephone book database of N clients. 
//Make use of a hash table implementation to quickly look up a client's telephone number.

//CRUD 

//Add new clients

//Search for a client’s phone number by name

//Update a client’s phone number

//Delete a client

//Display all clients

package DS;

import java.util.HashMap;
import java.util.Scanner;

public class TelephoneBook {
 private HashMap<String, String> phoneBook;

 public TelephoneBook() {
     phoneBook = new HashMap<>();
 }

 // Add a new client
 public void addClient(String name, String number) {
     phoneBook.put(name, number);
     System.out.println("Client added successfully!");
 }

 // Search for a client
 public void searchClient(String name) {
     if (phoneBook.containsKey(name)) {
         System.out.println("Name: " + name + ", Number: " + phoneBook.get(name));
     } else {
         System.out.println("Client not found.");
     }
 }

 // Update a client's number
 public void updateClient(String name, String newNumber) {
     if (phoneBook.containsKey(name)) {
         phoneBook.put(name, newNumber);
         System.out.println("Client updated successfully!");
     } else {
         System.out.println("Client not found.");
     }
 }

 // Delete a client
 public void deleteClient(String name) {
     if (phoneBook.remove(name) != null) {
         System.out.println("Client deleted successfully!");
     } else {
         System.out.println("Client not found.");
     }
 }

 // Display all clients
 public void displayAll() {
     if (phoneBook.isEmpty()) {
         System.out.println("Telephone book is empty.");
     } else {
         System.out.println("Telephone Book:");
         for (String name : phoneBook.keySet()) {
             System.out.println("Name: " + name + ", Number: " + phoneBook.get(name));
         }
     }
 }

 public static void main(String[] args) {
     TelephoneBook tb = new TelephoneBook();
     Scanner sc = new Scanner(System.in);
     int choice;

     do {
         System.out.println("\nTelephone Book Menu:");
         System.out.println("1. Add Client");
         System.out.println("2. Search Client");
         System.out.println("3. Update Client");
         System.out.println("4. Delete Client");
         System.out.println("5. Display All Clients");
         System.out.println("6. Exit");
         System.out.print("Enter your choice: ");
         choice = sc.nextInt();
         sc.nextLine(); // Consume newline

         String name, number;
         switch (choice) {
             case 1:
                 System.out.print("Enter client name: ");
                 name = sc.nextLine();
                 System.out.print("Enter client number: ");
                 number = sc.nextLine();
                 tb.addClient(name, number);
                 break;
             case 2:
                 System.out.print("Enter client name to search: ");
                 name = sc.nextLine();
                 tb.searchClient(name);
                 break;
             case 3:
                 System.out.print("Enter client name to update: ");
                 name = sc.nextLine();
                 System.out.print("Enter new number: ");
                 number = sc.nextLine();
                 tb.updateClient(name, number);
                 break;
             case 4:
                 System.out.print("Enter client name to delete: ");
                 name = sc.nextLine();
                 tb.deleteClient(name);
                 break;
             case 5:
                 tb.displayAll();
                 break;
             case 6:
                 System.out.println("Exiting...");
                 break;
             default:
                 System.out.println("Invalid choice.");
         }
     } while (choice != 6);
     sc.close();
 }
}
