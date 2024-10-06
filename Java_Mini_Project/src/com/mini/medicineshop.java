package com.mini;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class medicineshop {
    private DButil db = new DButil();
    private Statement stmt;
    private ResultSet rs;
    private Connection con;

    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Medicine ID, Name, Price, Quantity, Expiry Date (YYYY-MM-DD):");
        String id = scanner.next();
        String name = scanner.next() + scanner.nextLine();
        double price = scanner.nextDouble();
        int quantity = scanner.nextInt();
        String expiryDate = scanner.next();
        scanner.nextLine();

        try {
            con = db.getDBConnection();
            stmt = con.createStatement();
            String query = "INSERT INTO medical (id, name, price, quantity, expdate) VALUES ('" + id + "', '" + name + "', " + price + ", " + quantity + ", '" + expiryDate + "')";
            int count = stmt.executeUpdate(query);
            if (count > 0) {
                System.out.println("Medicine successfully added to the database!\n");
            } else {
                System.out.println("Error: Medicine was not added.\n");
            }
        } catch (Exception e) {
            System.out.println("Error while adding medicine: " + e.getMessage()+"\n");
        }
    }

    public void remove(String id) {
        try {
            con = db.getDBConnection();
            stmt = con.createStatement();
            int count = stmt.executeUpdate("DELETE FROM medical WHERE id = '" + id + "'");
            if (count > 0) {
                System.out.println("Successfully removed medicine from the database!\n");
            } else {
                System.out.println("Medicine with ID " + id + " not found in the database.\n");
            }
        } catch (Exception e) {
            System.out.println("Error while removing medicine: " + e.getMessage()+"\n");
        }
    }

    public void update(String id) {
        Scanner scanner = new Scanner(System.in);
        try {
            con = db.getDBConnection();
            stmt = con.createStatement();
            System.out.println("Enter new Name, Price, Quantity, Expiry Date (YYYY-MM-DD):");
            String name = scanner.nextLine();
            double price = scanner.nextDouble();
            int quantity = scanner.nextInt();
            String expiryDate = scanner.next();
            scanner.nextLine();

            String query = "UPDATE medical SET name = '" + name + "', price = " + price + ", quantity = " + quantity + ", expdate = '" + expiryDate + "' WHERE id = '" + id + "'";
            int count = stmt.executeUpdate(query);

            if (count > 0) {
                System.out.println("Medicine successfully updated in the database!\n");
            } else {
                System.out.println("Medicine with ID " + id + " not found in the database.\n");
            }
        } catch (Exception e) {
            System.out.println("Error while updating medicine: " + e.getMessage()+"\n");
        }
    }

    public void search(String id) {
        try {
            con = db.getDBConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM medical WHERE id = '" + id + "'");
            if (rs.next()) {
                System.out.println("Medicine ID: " + rs.getString("id"));
                System.out.println("Medicine Name: " + rs.getString("name"));
                System.out.println("Medicine Price: $" + rs.getDouble("price"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
                System.out.println("Expiry Date: " + rs.getDate("expdate")+"\n");
            } else {
                System.out.println("Medicine with ID " + id + " not found.\n");
            }
        } catch (Exception e) {
            System.out.println("Error while searching medicine: " + e.getMessage()+"\n");
        }
    }

    public void show() {
        try {
            con = db.getDBConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM medical");

            if (!rs.isBeforeFirst()) {
                System.out.println("No Medicines available in the database.\n");
                return;
            }

            System.out.println("Medicine details:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getString("id") + ", Name: " + rs.getString("name") + ", Price: $" + rs.getDouble("price") + ", Quantity: " + rs.getInt("quantity") + ", Expiry Date: " + rs.getDate("expdate"));
            }
        } catch (Exception e) {
            System.out.println("Error while fetching medicine details: " + e.getMessage()+"\n");
        }
    }
}
