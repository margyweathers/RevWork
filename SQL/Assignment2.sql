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
CREATE OR REPLACE FUNCTION INVOICE_LINE_PRICE_AVG
  RETURN NUMBER
  IS --can be is or as--
    AVERAGE NUMBER(3,2);
BEGIN
  SELECT AVG(UNITPRICE) INTO AVERAGE FROM INVOICELINE;
  RETURN AVERAGE;
END;
/
SELECT INVOICE_LINE_PRICE_AVG() FROM DUAL;

------------------------3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

/*  Why doesn't this work...?
DECLARE CURSOR emp IS SELECT FIRSTNAME FROM EMPLOYEE
  WHERE TITLE = 'IT Staff';
emp_name_result employee.firstname%type;
BEGIN
  OPEN emp;
  LOOP
    FETCH emp INTO emp_name_result;
    Dbms_output.put_line('Employee name: ' || emp_name_result);
  END LOOP;
END;
/
*/
CREATE OR REPLACE FUNCTION young_employees
  RETURN SYS_REFCURSOR
  AS cur SYS_REFCURSOR;
  BEGIN
    OPEN cur FOR SELECT FIRSTNAME, BIRTHDATE FROM EMPLOYEE
      WHERE BIRTHDATE >= TO_DATE('1968', 'YYYY');
    RETURN cur;
  END;
/
SELECT young_employees() FROM DUAL;


------------------------4.0 Stored Procedures
--In this section you will be creating and executing stored procedures. You will
--be creating various types of stored procedures that take input and output parameters.

-----------------------4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_first_and_last(
  cur OUT SYS_REFCURSOR)
  IS
  BEGIN
    OPEN cur FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/
--DROP PROCEDURE get_first_and_last;


-----------------------4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_EMP_ADDR(
  EMPID NUMBER,
  NEW_ADDRESS VARCHAR2,
  NEW_CITY VARCHAR2)
AS
BEGIN
  UPDATE EMPLOYEE
  SET ADDRESS = NEW_ADDRESS,
    CITY = NEW_CITY
    WHERE EMPLOYEEID = EMPID;
END;
/
EXECUTE UPDATE_EMP_ADDR(10, '1234 FUN STREET', 'ARLINGTON');

--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE get_managers(
  EMPID NUMBER,
  CUR OUT SYS_REFCURSOR)
  AS
  BEGIN
    OPEN CUR FOR 
      SELECT REPORTSTO FROM EMPLOYEE WHERE EMPLOYEEID = EMPID;
  END;
/

-----------------------4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE get_name_and_comp(
  CUSTID NUMBER,
  CUR OUT SYS_REFCURSOR)
  AS
  BEGIN
    OPEN CUR FOR
      SELECT FIRSTNAME,COMPANY FROM CUSTOMER WHERE CUSTOMERID = CUSTID;
  END;
/

-----------------------5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.

--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE delete_invoice(
      INVID IN NUMBER)
  AS
  BEGIN
    DELETE FROM INVOICELINE WHERE INVOICEID = INVID;
    DELETE FROM INVOICE WHERE INVOICEID = INVID;
    COMMIT;
  END;
/
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE insert_customer(
    CUSTID NUMBER,
    FIRST VARCHAR2,
    LAST VARCHAR2,
    COMP VARCHAR2,
    EM VARCHAR2)
  AS
  BEGIN
    INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, EMAIL) VALUES (CUSTID, FIRST, LAST, COMP, EM);
  END;
/
EXECUTE insert_customer(62, 'Margy','Weathers','Weary Traveler', 'margy@email.com');


-----------------------6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.

-----------------------6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER after_emp_trig
after INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN 
    DBMS_OUTPUT.put_line('Created an employee');
END;
/
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table.
CREATE OR REPLACE TRIGGER after_update_album_trig
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.put_line('Updated an album');
END;
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER after_delete_customer_trig
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.put_line('Deleted a customer');
END;
/

-----------------------7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with 
--outer, inner, right, left, cross, and self joins.

-----------------------7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CUSTOMER.FIRSTNAME AS "CUSTOMER NAME", INVOICE.INVOICEID AS "INVOICE ID"
  FROM CUSTOMER
  INNER JOIN INVOICE
  ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

-----------------------7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
  FROM CUSTOMER
  FULL OUTER JOIN INVOICE
  ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID
  ORDER BY CUSTOMER.FIRSTNAME;
  
-----------------------7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME AS "Artist name", ALBUM.TITLE AS "Album Title"
  FROM ALBUM
  RIGHT JOIN ARTIST
  ON ALBUM.ARTISTID = ARTIST.ARTISTID
  ORDER BY ARTIST.NAME;

-----------------------7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT ARTIST.NAME AS "Artist name", ALBUM.TITLE AS "Album Title"
  FROM ALBUM
  CROSS JOIN ARTIST
  ORDER BY ARTIST.NAME; 
  
-----------------------7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT E1.FIRSTNAME AS "Employee", E2.FIRSTNAME AS "Manager" 
  FROM EMPLOYEE E1
  LEFT JOIN EMPLOYEE E2
  ON E1.REPORTSTO = E2.EMPLOYEEID;
  
-----------------------7.6 Complicated Join assignment
--Create an inner join between all tables in the chinook database.
select  art.name as ARTIST, al.title AS "ALBUM TITLE", t.name as SONG, g.name as GENRE, 
pl.name as PLAYLIST, e.LASTNAME
from album al
join artist art on al.artistid = art.ARTISTID
join track t on t.ALBUMID = al.ALBUMID
join genre g on g.genreid = t.genreid
join mediatype mt on mt.MEDIATYPEID = t.MEDIATYPEID
join playlisttrack plt on plt.trackid = t.trackid 
join playlist pl on plt.playlistid = pl.PLAYLISTID
join invoiceline inl on inl.TRACKID = t.trackid
join invoice inv on inv.INVOICEID = inl.INVOICEID
join customer c on c.customerid = inv.CUSTOMERID
join employee e on c.SUPPORTREPID = e.employeeid
order by art.name;













--
--DECLARE
--   BOOKS_CURS SYS_REFCURSOR;
--   B_ID NUMBER(10);
--   B_ISBN VARCHAR2(10);
--   B_AUTHOR NUMBER(10);
--   B_TITLE VARCHAR2(100);
--   B_PRICE NUMBER(6,2);
--   B_GENRE NUMBER(10);
-- BEGIN
--   GET_ALL_BOOKS(BOOKS_CURS);
--   LOOP
--     FETCH BOOKS_CURS INTO B_ID, B_ISBN, B_AUTHOR, B_TITLE, B_PRICE, B_GENRE;
--     EXIT WHEN BOOKS_CURS%NOTFOUND;
--     DBMS_OUTPUT.PUT_LINE(B_ID || ', ' || B_TITLE);
--   END LOOP;
-- END;
-- /


