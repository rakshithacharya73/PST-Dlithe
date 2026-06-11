
use nitte2026_s;

select * from Customer;

DROP TABLE Customer;

CREATE TABLE Customer(
    CustomerID INT PRIMARY KEY,
    CustomerName VARCHAR(50),
    DOB DATE,
    ContactNo VARCHAR(15)
);