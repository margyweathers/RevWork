INSERT INTO USR (USERNAME, PW, FIRSTNAME, LASTNAME)
  VALUES('mweathers','password','Margy','Weathers');
INSERT INTO USR (USERNAME, PW, FIRSTNAME, LASTNAME)
  VALUES('user','pw','First','Last');
INSERT INTO USR (USERNAME, PW, FIRSTNAME, LASTNAME)
  VALUES('noaccounts','pw','No','Accounts');
INSERT INTO ACCOUNT (USER_ID, ACC_TYPE, NICKNAME, BALANCE, INTEREST, ACTIVE)
  VALUES(1, 1, 'my checkings', 1000, 0, 1);
INSERT INTO ACCOUNT (USER_ID, ACC_TYPE, NICKNAME, BALANCE, INTEREST, ACTIVE)
  VALUES(1, 2, 'my savings', 25000, 0, 1);
INSERT INTO ACCOUNT (USER_ID, ACC_TYPE, NICKNAME, BALANCE, INTEREST, ACTIVE)
  VALUES(2, 2, 'user savings', 12000, 0, 1);
INSERT INTO TRANSACTION(USER_ID, ACC_ID, ACC_NICKNAME, TRANS_TYPE, AMOUNT, NEWBAL, TRANSDATE)
  VALUES(1, 5, 'my checkings', 2, 200, 1200, 'fake date'); 
INSERT INTO TRANSACTION(USER_ID, ACC_ID, ACC_NICKNAME, TRANS_TYPE, AMOUNT, NEWBAL, TRANSDATE)
  VALUES(1, 5,'my checkings', 1, 300, 900, 'fake date'); 

commit;
delete from usr where user_id = 22;
delete from ACCOUNT where acc_id = 7;
delete from transaction where trans_id = 5;

SELECT * FROM TRANSACTION ORDER BY TRANS_ID;
SELECT * FROM USR;
SELECT * FROM ACCOUNT;
SELECT * FROM ACCOUNT_TYPE;
SELECT * FROM ACCOUNT WHERE USER_ID = 28;

UPDATE ACCOUNT
  SET BALANCE = 0, INTEREST = 0, ACTIVE = 1
  WHERE ACC_ID = 26;

