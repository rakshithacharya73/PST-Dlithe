package com.example;

public class Customer {

    private int customerId;
    private String customerName;
    private String dob;
    private String contactNo;

    public Customer(int customerId,
                    String customerName,
                    String dob,
                    String contactNo) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.dob = dob;
        this.contactNo = contactNo;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDob() {
        return dob;
    }

    public String getContactNo() {
        return contactNo;
    }
}