INSERT INTO USR(EMAIL, PWD, FIRSTNAME, LASTNAME, ROLL, APPROVED)
  VALUES('mweathers@gmail.com', 'pass', 'Margy', 'Weathers', 1, 1);
INSERT INTO USR(EMAIL, PWD, FIRSTNAME, LASTNAME, ROLL, APPROVED)
  VALUES('manager@gmail.com', '123', 'Financial', 'Manager', 2, 1);
INSERT INTO REIMBURSEMENTS (AUTHOR, R_RESOLVER, AMOUNT, SUBMIT_DATE, RESOLVE_DATE, R_TYPE, R_DESC, R_STATUS)
  VALUES(21, 22, 30.00, '11-11-2018 4:02', '11-19-2018 11:03', 2, 'Traveling to places.', 2);
INSERT INTO REIMBURSEMENTS (AUTHOR, R_RESOLVER, AMOUNT, SUBMIT_DATE, RESOLVE_DATE, R_TYPE, R_DESC, R_STATUS)
  VALUES(21, 22, 30.00, '10-10-2018 8:01', '10-11-2018 8:01', 3, 'Too much food.', 3);
INSERT INTO REIMBURSEMENTS (AUTHOR, AMOUNT, SUBMIT_DATE, R_TYPE, R_DESC, R_STATUS)
  VALUES(21, 30.00, '10-10-2018 8:01', 4, 'Pending request.', 1);


SELECT * FROM REIMBURSEMENT_TYPE ORDER BY R_TYPE_ID;
SELECT * FROM REIMBURSEMENTS ORDER BY R_ID;
SELECT * FROM REIMBURSEMENTS WHERE AUTHOR = 21 ORDER BY R_ID;
SELECT * FROM REIMBURSEMENTS WHERE R_RESOLVER = 22 ORDER BY R_ID;
SELECT * FROM USR;
SELECT * FROM USR WHERE EMAIL = 'mweathers@gmail.com';
SELECT EMAIL FROM USR;
update usr set roll=2 where user_id=22;



-----------------------------STORED PROCEDURES----------------------------------
CREATE OR REPLACE PROCEDURE GET_USR_EMAILS
(TRANS_CURSOR OUT SYS_REFCURSOR)
AS
BEGIN
OPEN TRANS_CURSOR FOR SELECT EMAIL FROM USR;
END;
/







