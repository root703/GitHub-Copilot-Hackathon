import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryManagementSystem {
    private Map<String, Integer> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(String productName, int quantity) {
        if (inventory.containsKey(productName)) {
            int currentQuantity = inventory.get(productName);
            inventory.put(productName, currentQuantity + quantity);
        } else {
            inventory.put(productName, quantity);
        }
    }

    public void updateProductQuantity(String productName, int newQuantity) {
        if (inventory.containsKey(productName)) {
            inventory.put(productName, newQuantity);
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    public void viewInventory() {
        System.out.println("Current Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            String productName = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(productName + ": " + quantity);
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Inventory Management System ===");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product Quantity");
            System.out.println("3. View Inventory");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String productName = scanner.next();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    ims.addProduct(productName, quantity);
                    System.out.println("Product added to inventory.");
                    break;
                case 2:
                    System.out.print("Enter product name: ");
                    String productToUpdate = scanner.next();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    ims.updateProductQuantity(productToUpdate, newQuantity);
                    break;
                case 3:
                    ims.viewInventory();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
2