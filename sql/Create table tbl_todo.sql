CREATE TABLE tbl_todo (
  tno NUMBER(10) PRIMARY KEY,
  todo VARCHAR2(100) NOT NULL,
  duedate DATE DEFAULT SYSDATE,
  finished NUMBER(1) DEFAULT 0 NOT NULL
);

-- sequence
CREATE SEQUENCE seq_tbl_todo
INCREMENT BY 1
START WITH 1
NOCACHE
NOCYCLE;

-- DML INSERT
INSERT INTO tbl_todo (tno, todo, duedate)
VALUES (seq_tbl_todo.nextval, 'jsp_공부', '2023-05-05');
-- Insert INTO tbl_todo (todo,duedate) values (?,?);

-- DML update 
UPDATE tbl_todo SET todo ='청소', duedate='2023-05-03'
WHERE tno =2;
-- UPDATE tbl_todo SET todo =?, duedate=? WHERE tno =?;

-- DML delete
delete from tbl_todo where tno=8;
-- delete from tbl_todo where tno=?;

-- DQL select 
select * from tbl_todo;
-- select * from tbl_todo;

-- view
select * from tbl_todo where tno=2;
-- select * from tbl_todo where tno=?;

select * from USERS;
