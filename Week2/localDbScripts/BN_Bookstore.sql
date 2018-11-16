/* DDL (Data Definition Language) Script for Book Store (Barnes & Noble) Example
Will contain a Genre, Book, Author table
*/

--CREATE TABLE [table name] ([column info][table level constraints]);
CREATE TABLE BN_GENRE(
  GENRE_ID NUMBER(10) PRIMARY KEY,
  NAME VARCHAR2(36) NOT NULL UNIQUE 
);

CREATE TABLE BN_AUTHOR(
  AUTHOR_ID NUMBER(10) PRIMARY KEY,
  FIRST_NAME VARCHAR2(50) NOT NULL,
  LAST_NAME VARCHAR2(50),
  BIO VARCHAR2(1000)
);

CREATE TABLE BN_BOOK(
  BOOK_ID NUMBER(10) PRIMARY KEY, 
  ISBN VARCHAR2(10) UNIQUE NOT NULL,
  AUTHOR NUMBER(10) NOT NULL,
  TITLE VARCHAR2(256) NOT NULL,
  PRICE NUMBER(6,2) NOT NULL,
  GENRE NUMBER(10) NOT NULL,
  CONSTRAINT FK_BOOK_GENRE --NOT NECESSARY TO NAME CONSTRAINTS BUT YOU CAN
  FOREIGN KEY(GENRE) REFERENCES BN_GENRE(GENRE_ID),
  FOREIGN KEY(AUTHOR) REFERENCES BN_AUTHOR(AUTHOR_ID)
);

------------------------------------SEQUENCES--------------------------------------------------
-- A set of integers that are generated in order on demand; usually used for autoincrementing pk values
CREATE SEQUENCE BN_BOOK_SEQ;
CREATE SEQUENCE BN_AUTHOR_SEQ;
CREATE SEQUENCE BN_GENRE_SEQ;




/*    TRIGGERS
  a trigger is a special type of stored procedure that automatically executes when an 
  event occurs in the database server. DML triggers execute when a user tries to
  modify data through a DML event. We will use them BEFORE each INSERT on a table
  to get the next value of our sequence and assign it to the PK value
*/

CREATE OR REPLACE TRIGGER BN_BOOK_TRIG -- declare and name trigger
BEFORE INSERT ON BN_BOOK -- when will trigger execute
FOR EACH ROW -- necessary to change value in a table 
BEGIN 
    -- SQL statement(s) to operate when event happens
    -- incrementing book seq and assigning it to a new book_id(book's pk) value
    SELECT BN_BOOK_SEQ.NEXTVAL INTO :NEW.BOOK_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER BN_AUTHOR_TRIG
BEFORE INSERT ON BN_AUTHOR
FOR EACH ROW
BEGIN 
    SELECT BN_AUTHOR_SEQ.NEXTVAL INTO :NEW.AUTHOR_ID FROM DUAL;
END;

/
CREATE OR REPLACE TRIGGER BN_GENRE_TRIG
Before INSERT ON BN_GENRE
FOR EACH ROW
BEGIN 
    SELECT BN_GENRE_SEQ.NEXTVAL INTO :NEW.GENRE_ID FROM DUAL;
END;
/



---------------------ADD VALUES
INSERT INTO BN_GENRE(NAME)
  VALUES('FICTION');
INSERT INTO BN_GENRE(NAME)
  VALUES('HISTORY');
INSERT INTO BN_GENRE(NAME)
  VALUES('SCI-FI');









