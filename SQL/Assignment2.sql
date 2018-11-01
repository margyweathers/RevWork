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
-- id = 32
SELECT CUSTOMERID FROM CUSTOMER
  WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';    -- Confirm unique name
UPDATE CUSTOMER
  SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
  WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST
  SET NAME = 'CCR'
  WHERE NAME = 'Creedence Clearwater Revival';
  
------------------------2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM INVOICE
  WHERE BILLINGADDRESS LIKE 'T%';

------------------------2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
  WHERE TOTAL >= 15 AND TOTAL <= 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE
  WHERE HIREDATE > TO_DATE('2003-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss') AND 
    HIREDATE < TO_DATE('2004-3-1 00:00:00','yyyy-mm-dd hh24:mi:ss');
    
------------------------2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may 
-- be constraints that rely on this, find out how to resolve them).
SELECT * FROM INVOICELINE
  WHERE INVOICEID IN ( SELECT INVOICEID FROM INVOICE
                        WHERE CUSTOMERID = 32  );
DELETE FROM INVOICELINE
  WHERE INVOICEID IN ( SELECT INVOICEID FROM INVOICE
                        WHERE CUSTOMERID = 32  );
DELETE FROM INVOICE
  WHERE CUSTOMERID = 32;
DELETE FROM CUSTOMER
  WHERE CUSTOMERID = 32;
SELECT * FROM CUSTOMER;

------------------------3.0 SQL Functions

------------------------3.1 System Defined Functions
--Task – Create a function that returns the current time.
alter session set NLS_DATE_FORMAT= 'HH:MIpm';
select sysdate from dual;
--Task – create a function that returns the length of a mediatype from the mediatype table
SELECT * FROM MEDIATYPE;
SELECT LENGTH((SELECT NAME FROM MEDIATYPE WHERE MEDIATYPEID =1)) "Media name length" from dual;

------------------------3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
SELECT * FROM INVOICE;
SELECT AVG(TOTAL) "Average Total" FROM INVOICE;
--Task – Create a function that returns the most expensive track
SELECT * FROM TRACK
WHERE UNITPRICE = ( SELECT MAX(UNITPRICE) FROM TRACK);

------------------------3.3 User Defined Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avginvoiceline

  RETURN INT
BEGIN
  RETURN AVG(TOTAL) "Average Total" FROM INVOICE
END;
  
SELECT * FROM INVOICELINE;









