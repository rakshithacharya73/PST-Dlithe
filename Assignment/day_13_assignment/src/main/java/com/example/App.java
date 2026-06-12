package com.example;


import java.sql.*;
import java.util.Scanner;

public class App {

    // Add Customer
    public static void addCustomer(Customer customer) {

        String sql =
                "INSERT INTO Customer VALUES(?,?,?,?)";

        try (Connection con =
                     DBConnection.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setInt(1, customer.getCustomerId());
            ps.setString(2, customer.getCustomerName());
            ps.setDate(3,
                    Date.valueOf(customer.getDob()));
            ps.setString(4, customer.getContactNo());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println(
                        "Customer Added Successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fetch Customers with Same DOB
    public static void fetchByDOB(String dob) {

        String sql =
                "SELECT * FROM Customer WHERE DOB=?";

        try (Connection con =
                     DBConnection.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(dob));

            ResultSet rs = ps.executeQuery();

            System.out.println(
                    "\nCustomers having DOB : " + dob);

            while (rs.next()) {

                System.out.println(
                        rs.getInt("CustomerID") + " "
                                + rs.getString("CustomerName")
                                + " "
                                + rs.getDate("DOB")
                                + " "
                                + rs.getString("ContactNo"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter DOB (yyyy-mm-dd): ");
        String dob = sc.nextLine();

        System.out.print("Enter Contact No: ");
        String contact = sc.nextLine();

        Customer customer =
                new Customer(id, name, dob, contact);

        addCustomer(customer);

        System.out.print(
                "\nEnter DOB to Search (yyyy-mm-dd): ");

        String searchDob = sc.nextLine();

        fetchByDOB(searchDob);

        sc.close();
    }
}