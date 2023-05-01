CREATE TABLE tbl_todo (
  tno NUMBER(10) PRIMARY KEY,
  todo VARCHAR2(100) NOT NULL,
  duedate DATE DEFAULT SYSDATE,
  finished NUMBER(1) DEFAULT 0 NOT NULL
);