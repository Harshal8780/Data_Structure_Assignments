//Create a Dictionary that stores keywords and its meanings, using appropriate data structure. 
//Implement its operations such as add, delete, display, search and update its values.

//CRUD - Create Read Update Delete

package DS;

import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {
 private HashMap<String, String> dict;

 public Dictionary() {
     dict = new HashMap<>();
 }

 // Add a new keyword and meaning
 public void add(String keyword, String meaning) {
     dict.put(keyword, meaning);
     System.out.println("Added successfully!");
 }

 // Delete a keyword
 public void delete(String keyword) {
     if (dict.remove(keyword) != null) {
         System.out.println("Deleted successfully!");
     } else {
         System.out.println("Keyword not found.");
     }
 }

 // Display all keywords and meanings
 public void display() {
     if (dict.isEmpty()) {
         System.out.println("Dictionary is empty.");
     } else {
         System.out.println("Dictionary contents:");
         for (String word : dict.keySet()) {
             System.out.println(word + " : " + dict.get(word)); // .get(word) = meaning of that word
         }
     }
 }

 // Search for a keyword
 public void search(String keyword) {
     if (dict.containsKey(keyword)) {
         System.out.println(keyword + " : " + dict.get(keyword));
     } else {
         System.out.println("Keyword not found.");
     }
 }

 // Update the meaning of a keyword
 public void update(String keyword, String newMeaning) {
     if (dict.containsKey(keyword)) {
         dict.put(keyword, newMeaning);
         System.out.println("Updated successfully!");
     } else {
         System.out.println("Keyword not found.");
     }
 }

 public static void main(String[] args) {
     Dictionary dictionary = new Dictionary();
     Scanner sc = new Scanner(System.in);
     int choice;
     do {
         System.out.println("\nDictionary Menu:");
         System.out.println("1. Add");
         System.out.println("2. Delete");
         System.out.println("3. Display");
         System.out.println("4. Search");
         System.out.println("5. Update");
         System.out.println("6. Exit");
         System.out.print("Enter your choice: ");
         choice = sc.nextInt();
         sc.nextLine(); // consume newline

         switch (choice) {
             case 1:
                 System.out.print("Enter keyword: ");
                 String keyword = sc.nextLine();
                 System.out.print("Enter meaning: ");
                 String meaning = sc.nextLine();
                 dictionary.add(keyword, meaning);
                 break;
             case 2:
                 System.out.print("Enter keyword to delete: ");
                 keyword = sc.nextLine();
                 dictionary.delete(keyword);
                 break;
             case 3:
                 dictionary.display();
                 break;
             case 4:
                 System.out.print("Enter keyword to search: ");
                 keyword = sc.nextLine();
                 dictionary.search(keyword);
                 break;
             case 5:
                 System.out.print("Enter keyword to update: ");
                 keyword = sc.nextLine();
                 System.out.print("Enter new meaning: ");
                 meaning = sc.nextLine();
                 dictionary.update(keyword, meaning);
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
