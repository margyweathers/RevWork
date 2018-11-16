CREATE TABLE USERS(
  USER_ID NUMBER(10) PRIMARY KEY,
  EMAIL VARCHAR2(100) UNIQUE NOT NULL,
  PWD VARCHAR2(50) NOT NULL,
  FIRSTNAME VARCHAR2(50) NOT NULL,
  LASTNAME VARCHAR2(50) NOT NULL,
  ROLL NUMBER(2) NOT NULL
);

CREATE TABLE USER_ROLLS(
  ROLL_ID NUMBER(2) PRIMARY KEY,
  ROLL_TYPE VARCHAR(50) NOT NULL
);

CREATE TABLE REIMBURSEMENTS(
  R_ID NUMBER(10) PRIMARY KEY,
  AUTHOR NUMBER(10) NOT NULL,
  R_RESOLVER NUMBER(10),
  AMOUNT NUMBER(10,2) NOT NULL,
  SUBMIT_DATE VARCHAR2(30) NOT NULL,
  RESOLVE_DATE VARCHAR2(30),
  R_TYPE NUMBER(3) NOT NULL,
  R_DESC VARCHAR2(250),
  R_STATUS NUMBER(3) NOT NULL
);

CREATE TABLE REIMBURSEMENT_TYPE(
  R_TYPE_ID NUMBER(3) PRIMARY KEY,
  R_TYPE VARCHAR2(50) UNIQUE NOT NULL
);

CREATE TABLE STATUS_TYPE(
  STATUS_TYPE_ID NUMBER(10) PRIMARY KEY,
  STATUS_TYPE VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE RESUBMIT(
  RESUBMIT_ID NUMBER(10) PRIMARY KEY,
  ORIG_R_ID NUMBER(10),
  AUTHOR NUMBER(10) NOT NULL,
  R_RESOLVER NUMBER(10),
  AMOUNT NUMBER(10,2) NOT NULL,
  SUBMIT_DATE VARCHAR2(30) NOT NULL,
  RESUBMIT_DATE VARCHAR2(30) NOT NULL,
  RESOLVE_DATE VARCHAR2(30),
  R_TYPE NUMBER(3) NOT NULL,
  R_DESC VARCHAR2(250),
  R_STATUS NUMBER(3) NOT NULL
);


----------------------------------Set Constraints-------------------------------
--- REIMBERSEMENT CONSTRAINTS
ALTER TABLE REIMBURSEMENTS
  ADD CONSTRAINT author_to_user_id_fk
  FOREIGN KEY (AUTHOR)
  REFERENCES USERS(USER_ID)
  ON DELETE CASCADE;
ALTER TABLE REIMBURSEMENTS
  ADD CONSTRAINT resolver_to_user_id_fk
  FOREIGN KEY (R_RESOLVER)
  REFERENCES USERS(USER_ID)
  ON DELETE CASCADE;
ALTER TABLE REIMBURSEMENTS
  ADD CONSTRAINT status_type_fk
  FOREIGN KEY (R_STATUS)
  REFERENCES STATUS_TYPE(STATUS_TYPE_ID)
  ON DELETE CASCADE;
ALTER TABLE REIMBURSEMENTS
  ADD CONSTRAINT reimbursement_type_fk
  FOREIGN KEY (R_TYPE)
  REFERENCES REIMBURSEMENT_TYPE(R_TYPE_ID)
  ON DELETE CASCADE;
 
--- RESUBMIT CONSTRAINTS  
ALTER TABLE RESUBMIT
  ADD CONSTRAINT resubmit_to_orig_id
  FOREIGN KEY (ORIG_R_ID)
  REFERENCES REIMBURSEMENTS(R_ID)
  ON DELETE CASCADE;
ALTER TABLE RESUBMIT
  ADD CONSTRAINT REauthor_to_user_id_fk
  FOREIGN KEY (AUTHOR)
  REFERENCES USERS(USER_ID)
  ON DELETE CASCADE;
ALTER TABLE RESUBMIT
  ADD CONSTRAINT REresolver_to_user_id_fk
  FOREIGN KEY (R_RESOLVER)
  REFERENCES USERS(USER_ID)
  ON DELETE CASCADE;
ALTER TABLE RESUBMIT
  ADD CONSTRAINT REstatus_type_fk
  FOREIGN KEY (R_STATUS)
  REFERENCES STATUS_TYPE(STATUS_TYPE_ID)
  ON DELETE CASCADE;
ALTER TABLE RESUBMIT
  ADD CONSTRAINT REreimbursement_type_fk
  FOREIGN KEY (R_TYPE)
  REFERENCES REIMBURSEMENT_TYPE(R_TYPE_ID)
  ON DELETE CASCADE;
  
--- USER ROLL CONSTRAINTS
ALTER TABLE USERS
  ADD CONSTRAINT roll_type_fk
  FOREIGN KEY (ROLL)
  REFERENCES USER_ROLLS(ROLL_ID)
  ON DELETE CASCADE;
  
-------------------------------Create Sequences--------------------------------
CREATE SEQUENCE USER_SEQ;
CREATE SEQUENCE REIMBURSEMENT_SEQ;
CREATE SEQUENCE RESUBMIT_SEQ;

----------------------------Create Auto-gen Triggers----------------------------
CREATE OR REPLACE TRIGGER USER_ID_TRIG
BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN 
    SELECT USER_SEQ.NEXTVAL INTO : NEW.USER_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER REIMBURSEMENT_ID_TRIG
BEFORE INSERT ON REIMBURSEMENTS
FOR EACH ROW
BEGIN 
    SELECT REIMBURSEMENT_SEQ.NEXTVAL INTO : NEW.R_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER RESUBMIT_ID_TRIG
BEFORE INSERT ON RESUBMIT
FOR EACH ROW
BEGIN 
    SELECT RESUBMIT_SEQ.NEXTVAL INTO : NEW.RESUBMIT_ID FROM DUAL;
END;
/


-----------------------------POPULATE TYPE TABLES-------------------------------
INSERT INTO USER_ROLLS (ROLL_ID, ROLL_TYPE)
  VALUES(1, 'EMPLOYEE');
INSERT INTO USER_ROLLS (ROLL_ID, ROLL_TYPE)
  VALUES(2, 'MANAGER');

INSERT INTO STATUS_TYPE (STATUS_TYPE_ID, STATUS_TYPE)
  VALUES(1, 'PENDING');
INSERT INTO STATUS_TYPE (STATUS_TYPE_ID, STATUS_TYPE)
  VALUES(2, 'APPROVED');
INSERT INTO STATUS_TYPE (STATUS_TYPE_ID, STATUS_TYPE)
  VALUES(3, 'DENIED');
INSERT INTO STATUS_TYPE (STATUS_TYPE_ID, STATUS_TYPE)
  VALUES(4, 'RESUBMITTED');





-------------------------------STORED PROCEDURES--------------------------------









