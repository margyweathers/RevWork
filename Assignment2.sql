/*
* Margaret Weathers Week 2 Assignment
*/

------------------------2.1 SELECT
--Task – Select all records from the Employee table. 
SELECT * FROM EMPLOYEE;
--Task – Select all records from the Employee table where last name is King
SELECT * FROM EMPLOYEE
  WHERE LASTNAME = 'King';
--Task – Select all records from the Employee table where first name is Andrew 
--  and REPORTSTO is NULL
SELECT * FROM EMPLOYEE
  WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

------------------------2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT TITLE FROM ALBUM
  ORDER BY TITLE DESC;
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT CITY, FIRSTNAME FROM CUSTOMER
  ORDER BY CITY;
  
------------------------2.3 INSERT INTO
--Task – Insert two new records into Genre table
SELECT * FROM GENRE;
INSERT INTO GENRE VALUES (30, 'Good Music');
INSERT INTO GENRE VALUES (31, 'Bad Music');
--Task – Insert two new records into Employee table
SELECT * FROM EMPLOYEE;
INSERT INTO EMPLOYEE VALUES (10, 'Employee', 'Sample', 'Sales Support Agent', 5, TO_DATE('2018-10-22 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2018-10-30 00:00:00','yyyy-mm-dd hh24:mi:ss'), '1111 Street St', 'Reston', 'VA', 'Canada', 'T2P 5M5', '+1 (403) 262-3443', '+1 (403) 262-6712', 'sample@chinookcorp.com');
INSERT INTO EMPLOYEE VALUES (11, 'SameThing', 'Sample', 'Sales Support Agent', 5, TO_DATE('2018-10-22 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2018-10-30 00:00:00','yyyy-mm-dd hh24:mi:ss'), '1111 Street St', 'Reston', 'VA', 'Canada', 'T2P 5M5', '+1 (403) 262-3443', '+1 (403) 262-6712', 'sample@chinookcorp.com');
--Task – Insert two new records into Customer table
SELECT * FROM CUSTOMER;
INSERT INTO CUSTOMER (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (60, 'Margy', 'Weathers', '11 Address Rd.', 'Bangalore', 'India', '560001', '+91 080 22289999', 'mweathers@gmail.com', 3);
INSERT INTO CUSTOMER (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (61, 'Margy', 'Weathers22!', '11 Address Rd.', 'Bangalore', 'India', '560001', '+91 080 22289999', 'mweathers@gmail.com', 3);

------------------------2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter



