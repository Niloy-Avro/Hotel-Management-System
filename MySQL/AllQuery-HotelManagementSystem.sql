-- Craeting database
CREATE DATABASE hotelEE;

-- Selecting database
USE hotelEE;

-- Showing all database
SHOW DATABASES;

-- creating table to store login info
CREATE TABLE login (
	username VARCHAR(25),
    password VARCHAR(25)
)
SELECT * FROM login;
SET SQL_SAFE_UPDATES = 0; -- kono data dlt korte gele mysql er by default safe_updates value tak 1 theke 0 kore nite hoy
INSERT INTO login VALUES('Niloy','123456');
INSERT INTO login VALUES('Niloy Avro','123456789');
DELETE FROM login WHERE username = 'Niloy Avro' AND password = '123456789';
SET SQL_SAFE_UPDATES = 1;

-- creating Room Table
CREATE TABLE room (
	roomnumber INTEGER AUTO_INCREMENT PRIMARY KEY,
    availability VARCHAR(20),
    price VARCHAR(20),
    bed_type VARCHAR(20),
    cleaning_status VARCHAR(20)
);
ALTER TABLE room MODIFY roomnumber INTEGER;
SELECT * FROM room;



-- creating Employee Table
CREATE TABLE employee (
	name VARCHAR(20),
    contact_number VARCHAR(18),
    email VARCHAR(50),
    gender VARCHAR(15),
    education_details VARCHAR(20)
);
ALTER TABLE employee ADD empID INTEGER PRIMARY KEY;
ALTER TABLE employee MODIFY empID INTEGER AUTO_INCREMENT;
ALTER TABLE employee MODIFY empID INTEGER;
ALTER TABLE employee ADD department VARCHAR(50) DEFAULT "Not Assigned";
SELECT * FROM employee;



-- creating driver table
CREATE TABLE driver (
	driverID INT PRIMARY KEY,
    name VARCHAR(20),
    mbNumber VARCHAR(20),
    carCompany VARCHAR(20),
    carModel VARCHAR(20),
    Available VARCHAR(20) DEFAULT "YES"
);
SELECT * FROM driver;



-- creating table to store Admin login info
CREATE TABLE adminLogin (
	username VARCHAR(25),
    password VARCHAR(25)
);
SELECT * FROM adminLogin;
INSERT INTO adminLogin VALUES('Niloy Avro','123456789');


-- creating department table
CREATE TABLE department (
	deptID INT PRIMARY KEY,
    department VARCHAR(30),
    budget INT(30)
);
INSERT INTO department VALUES
(100,"Manager",65000),
(101,"Reception",40000),
(102,"Housekeeping",35000),
(103,"Food",55000),
(104,"Parking and Security",50000);
SET SQL_SAFE_UPDATES = 0;
UPDATE department SET department="Security" WHERE department="Parking and Security";
SET SQL_SAFE_UPDATES = 1;
SELECT * FROM department;

-- creating Customer Table
CREATE TABLE customer (
	document VARCHAR(50),
    name VARCHAR(30),
    number VARCHAR(30),
    gender VARCHAR(10),
    room VARCHAR(50),
    deposit INTEGER,
    checkintime VARCHAR(80)
);
ALTER TABLE customer CHANGE number IDnumber INT; -- numnber er nam change kore IDnumber korlam
ALTER TABLE customer ADD UNIQUE (IDnumber); -- IDnumber sobar unique hobe
ALTER TABLE customer MODIFY IDnumber VARCHAR(50); -- IDnumber VARCHAR korlam
SELECT * FROM customer;




