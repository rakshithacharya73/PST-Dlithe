package com.example;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerAPI {

    // Add Customer
    public void addCustomer(int id, String name, String dob, String contact) {

        String sql = "INSERT INTO Customer VALUES(?,?,?,?)";

        try (Connection con = Connecting.getConnect();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, dob);
            ps.setString(4, contact);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Customer Added Successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch Customers by DOB
    public void fetchByDOB(String dob) {

        String sql = "SELECT * FROM Customer WHERE DOB=?";

        try (Connection con = Connecting.getConnect();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dob);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("CustomerID") + " | " +
                        rs.getString("CustomerName") + " | " +
                        rs.getDate("DOB") + " | " +
                        rs.getString("ContactNo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}