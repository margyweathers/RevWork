INSERT INTO USR(EMAIL, PWD, FIRSTNAME, LASTNAME, ROLL)
  VALUES('mweathers@gmail.com', 'pass', 'Margy', 'Weathers', 1);
INSERT INTO USR(EMAIL, PWD, FIRSTNAME, LASTNAME, ROLL)
  VALUES('manager@gmail.com', '123', 'Financial', 'Manager', 1);

SELECT * FROM USR;
SELECT * FROM USR WHERE EMAIL = 'mweathers@gmail.com';
SELECT EMAIL FROM USR;




-----------------------------STORED PROCEDURES----------------------------------
CREATE OR REPLACE PROCEDURE GET_USR_EMAILS
(TRANS_CURSOR OUT SYS_REFCURSOR)
AS
BEGIN
OPEN TRANS_CURSOR FOR SELECT EMAIL FROM USR;
END;
/







