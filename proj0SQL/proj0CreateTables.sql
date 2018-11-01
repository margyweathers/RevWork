/*
Setup Banking App Tables
*/

CREATE TABLE USR(
  USER_ID NUMBER(10) PRIMARY KEY,
  USERNAME VARCHAR(40) UNIQUE NOT NULL,
  PW VARCHAR(50) NOT NULL,
  FIRSTNAME VARCHAR(50) NOT NULL,
  LASTNAME VARCHAR(50) NOT NULL
);

CREATE TABLE ACCOUNT(
  ACC_ID NUMBER(10) PRIMARY KEY,
  USER_ID NUMBER(10) NOT NULL,
  ACC_TYPE NUMBER(2) NOT NULL,
  NICKNAME VARCHAR2(50) UNIQUE NOT NULL,
  BALANCE NUMBER(13,2) NOT NULL,
  INTEREST NUMBER(1,5)
);

CREATE TABLE ACCOUNT_TYPE(
  TYPE_ID NUMBER(2) PRIMARY KEY,
  TYPE_NAME VARCHAR2(20) UNIQUE NOT NULL
);

CREATE TABLE TRANSACTION(
  TRANS_ID NUMBER(10) PRIMARY KEY,
  USER_ID NUMBER(10) NOT NULL,
  TRANS_TYPE NUMBER(2) NOT NULL,
  AMOUNT NUMBER(13,2) NOT NULL
);  

CREATE TABLE TRANSACTION_TYPE(
  TYPE_ID NUMBER(2) PRIMARY KEY,
  TYPE_NAME VARCHAR2(20) UNIQUE NOT NULL
);
--drop table transaction_type2;

------------------------Set Constraints------------------------

ALTER TABLE ACCOUNT
ADD CONSTRAINT set_accountToUser_fk
  FOREIGN KEY (USER_ID)
  REFERENCES USR(USER_ID)
  ON DELETE CASCADE;
ALTER TABLE ACCOUNT
ADD CONSTRAINT set_accountToType_fk
  FOREIGN KEY (ACC_TYPE)
  REFERENCES ACCOUNT_TYPE(TYPE_ID)
  ON DELETE CASCADE;
--ALTER TABLE ACCOUNT DROP CONSTRAINT set_account_fk;

ALTER TABLE TRANSACTION
ADD CONSTRAINT set_transToUser_fk
  FOREIGN KEY (USER_ID)
  REFERENCES USR(USER_ID)
  ON DELETE CASCADE;
ALTER TABLE TRANSACTION
ADD CONSTRAINT set_transToType_fk
  FOREIGN KEY (TRANS_TYPE)
  REFERENCES TRANSACTION_TYPE(TYPE_ID)
  ON DELETE CASCADE;
--ALTER TABLE TRANSACTION DROP CONSTRAINT set_transToType_fk;
--ALTER TABLE TRANSACTION DROP CONSTRAINT set_transToUSER_fk;



