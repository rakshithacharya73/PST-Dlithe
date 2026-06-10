create database assignment;
use assignment;
-- Create the following tables and perform following aggregations: 
-- Customer(CustomerID, CustomerName, DOB, ContactNo) PolicyType(PolicyType, PremiumRate, CoverageYears) Branch(BranchID, BranchName, Manager) Policy(PolicyID, CustomerID, PolicyType, PremiumAmount, BranchID)
-- Insert sample data: Customers: C1: Ramesh, 1985‑05‑10, 9876543210 C2: Kavya, 1990‑09‑15, 9123456789
-- PolicyTypes: Health – 5% premium, 10 years coverage Life – 8% premium, 20 years coverage Vehicle – 6% premium, 5 years coverage
-- Branches: B1: Bangalore – Manager: Anil B2: Mysore – Manager: Sneha
-- Policies: P1: C1, Health, 20000, B1 P2: C1, Vehicle, 15000, B1 P3: C2, Life, 50000, B2

-- a. Write a query to find the maximum premium amount per branch. 
-- b. Write a query to list customers who have more than one policy. 
-- c. Write a query to calculate the total annual premium payable per branch.

CREATE TABLE Customer (
    CustomerID VARCHAR(10) PRIMARY KEY,
    CustomerName VARCHAR(50),
    DOB DATE,
    ContactNo VARCHAR(15)
);

CREATE TABLE PolicyType (
    PolicyType VARCHAR(20) PRIMARY KEY,
    PremiumRate DECIMAL(5,2),
    CoverageYears INT
);

CREATE TABLE Branch (
    BranchID VARCHAR(10) PRIMARY KEY,
    BranchName VARCHAR(50),
    Manager VARCHAR(50)
);

CREATE TABLE Policy (
    PolicyID VARCHAR(10) PRIMARY KEY,
    CustomerID VARCHAR(10),
    PolicyType VARCHAR(20),
    PremiumAmount DECIMAL(10,2),
    BranchID VARCHAR(10),
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
    FOREIGN KEY (PolicyType) REFERENCES PolicyType(PolicyType),
    FOREIGN KEY (BranchID) REFERENCES Branch(BranchID)
);

INSERT INTO Customer VALUES
('C1', 'Ramesh', '1985-05-10', '9876543210'),
('C2', 'Kavya', '1990-09-15', '9123456789');

INSERT INTO PolicyType VALUES
('Health', 5.00, 10),
('Life', 8.00, 20),
('Vehicle', 6.00, 5);

INSERT INTO Branch VALUES
('B1', 'Bangalore', 'Anil'),
('B2', 'Mysore', 'Sneha');

INSERT INTO Policy VALUES
('P1', 'C1', 'Health', 20000, 'B1'),
('P2', 'C1', 'Vehicle', 15000, 'B1'),
('P3', 'C2', 'Life', 50000, 'B2');

select * from policy;
-- a. Write a query to find the maximum premium amount per branch. 
SELECT 
    B.BranchID,
    B.BranchName,
    MAX(P.PremiumAmount) AS MaxPremium
FROM Branch B
JOIN Policy P ON B.BranchID = P.BranchID
GROUP BY B.BranchID, B.BranchName;

-- b. Write a query to list customers who have more than one policy. 
SELECT 
    C.CustomerID,
    C.CustomerName,
    COUNT(P.PolicyID) AS NumberOfPolicies
FROM Customer C
JOIN Policy P ON C.CustomerID = P.CustomerID
GROUP BY C.CustomerID, C.CustomerName
HAVING COUNT(P.PolicyID) > 1;

-- c. Write a query to calculate the total annual premium payable per branch.
SELECT 
    B.BranchID,
    B.BranchName,
    SUM(P.PremiumAmount) AS TotalAnnualPremium
FROM Branch B
JOIN Policy P ON B.BranchID = P.BranchID
GROUP BY B.BranchID, B.BranchName;

-- select  creditcard.card_holder ,max(PremiumAmount) as MAX
-- from Policy
-- join creditcard on t_by=creditcard.card_no
-- group by creditcard.card_holder;


-- Consider the above tables and perform below DCL:
-- a. Log in as branch_manager and try to: Insert a new policy → should succeed. Update an existing policy → should fail after revoke.
-- b. Log in as policy_auditor and try to: Run SELECT * FROM Policy; → should succeed. Run INSERT INTO Policy ... → should fail.
-- c. Log in as policy_admin and try to: Drop a table → should succeed. Grant privileges to another user → should succeed.

CREATE USER 'branch_manager'@'localhost' IDENTIFIED BY 'bm123';
CREATE USER 'policy_auditor'@'localhost' IDENTIFIED BY 'pa123';
CREATE USER 'policy_admin'@'localhost' IDENTIFIED BY 'admin123';

GRANT INSERT, UPDATE ON assignment.Policy
TO 'branch_manager'@'localhost';

GRANT SELECT ON assignment.Policy
TO 'policy_auditor'@'localhost';

GRANT ALL PRIVILEGES ON assignment.*
TO 'policy_admin'@'localhost'
WITH GRANT OPTION;

FLUSH PRIVILEGES;

-- INSERT INTO Policy
-- VALUES ('P4','C2','Health',25000,'B2');

-- REVOKE UPDATE ON assignment.Policy
-- FROM 'branch_manager'@'localhost';

-- FLUSH PRIVILEGES;

-- UPDATE Policy
-- SET PremiumAmount = 30000
-- WHERE PolicyID='P4';

-- INSERT INTO Policy
-- VALUES ('P5','C1','Life',45000,'B1');

-- DROP TABLE Branch;

-- GRANT SELECT
-- ON assignment.Customer
-- TO 'policy_auditor'@'localhost';

