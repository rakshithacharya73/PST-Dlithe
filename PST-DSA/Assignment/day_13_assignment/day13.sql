
CREATE DATABASE customerdb;

USE customerdb;

CREATE TABLE Customer (
    CustomerID INT PRIMARY KEY,
    CustomerName VARCHAR(100),
    DOB DATE,
    ContactNo VARCHAR(15)
);