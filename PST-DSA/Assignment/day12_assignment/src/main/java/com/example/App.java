package com.example;

public class App {

    public static void main(String[] args) {

        CustomerAPI api = new CustomerAPI();

        // Add Customer
        api.addCustomer(
                101,
                "Ramesh",
                "2002-05-10",
                "9876543210"
        );

        // Fetch Customers with same DOB
        System.out.println("\nCustomers Having DOB 2002-05-10:");

        api.fetchByDOB("2002-05-10");
    }
}

// java -jar target/day12_assignment-1.0-SNAPSHOT.jar
