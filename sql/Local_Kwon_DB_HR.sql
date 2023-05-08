
select * from USERS;
delete from USERS where username = '권성준';

commit;

CREATE TABLE USERS (
  username VARCHAR2(255) NOT NULL,
  email VARCHAR2(255) NOT NULL,
  id VARCHAR2(255) NOT NULL,
  password VARCHAR2(255) NOT NULL,
  passwordChangeInterval NUMBER NOT NULL,
  last_password_change DATE NOT NULL,
  CONSTRAINT users_pk PRIMARY KEY (id)
);

ALTER TABLE USERS
ADD (
  verificationCode VARCHAR2(255) DEFAULT '' NOT NULL,
  isVerified NUMBER(1,0) DEFAULT 0 NOT NULL
);



CREATE TABLE USER_LOGS (
  id NUMBER(10) PRIMARY KEY,
  user_id VARCHAR2(255) NOT NULL,
  timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE SEQUENCE USER_LOGS_SEQ START WITH 1 INCREMENT BY 1;

select * from USER_LOGS;







