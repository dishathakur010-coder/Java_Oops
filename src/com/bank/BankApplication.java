CREATE DATABASE banking_system;
USE banking_system;
CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);
CREATE TABLE accounts (
    account_number BIGINT PRIMARY KEY,
    balance DOUBLE,
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
CREATE TABLE loans (
    loan_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    loan_amount DOUBLE,
    interest_rate DOUBLE,
    tenure INT
);
