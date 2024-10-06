package com.mini;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        medicineshop inventory = new medicineshop();
        User currentUser = new User();
        int choice;

        System.out.println("Welcome to the Dispensary Management System");

        while (true) { // Outer loop for login/logout functionality
            boolean loggedIn = false;
            boolean isAdmin = false;

            // Login prompt loop
            while (!loggedIn) {
                System.out.println("\nEnter Name:");
                currentUser.setName(scanner.nextLine());
                System.out.println("Enter Password:");
                currentUser.setPass(scanner.nextLine());

                if (currentUser.getName().equals("admin") && currentUser.getPass().equals("admin")) {
                    loggedIn = true;
                    isAdmin = true;
                    System.out.println("Logged in as admin.");
                } else if (currentUser.getName().equals("user") && currentUser.getPass().equals("user")) {
                    loggedIn = true;
                    System.out.println("Logged in as user.");
                } else {
                    System.out.println("Invalid login. Please try again.");
                }
            }

            // Main menu based on user type
            if (isAdmin) {
                do {
                    System.out.println("\nAdmin Options:");
                    System.out.println("1. Add Medication");
                    System.out.println("2. Remove Medication");
                    System.out.println("3. Update Medication");
                    System.out.println("4. Search Medication");
                    System.out.println("5. Show All Medications");
                    System.out.println("6. Log out");

                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            inventory.add();
                            break;
                        case 2:
                            System.out.println("Enter the ID to remove:");
                            String removeId = scanner.nextLine();
                            inventory.remove(removeId);
                            break;
                        case 3:
                            System.out.println("Enter the ID to update:");
                            String updateId = scanner.nextLine();
                            inventory.update(updateId);
                            break;
                        case 4:
                            System.out.println("Enter the ID to search:");
                            String searchId = scanner.nextLine();
                            inventory.search(searchId);
                            break;
                        case 5:
                            inventory.show();
                            break;
                        case 6:
                            System.out.println("Logging out...");
                            loggedIn = false; // Log out by breaking the loop
                            break;
                    
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } while (choice != 6);
            } else { // User options
                do {
                    System.out.println("\nUser Options:");
                    System.out.println("1. Show All Medications");
                    System.out.println("2. Search Medication");
                    System.out.println("3. Log out");

                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            inventory.show();
                            break;
                        case 2:
                            System.out.println("Enter the ID to search:");
                            String searchId = scanner.nextLine();
                            inventory.search(searchId);
                            break;
                        case 3:
                            System.out.println("Logging out...");
                            loggedIn = false; // Log out by breaking the loop
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } while (choice != 3);
            }
        }
    }
}
