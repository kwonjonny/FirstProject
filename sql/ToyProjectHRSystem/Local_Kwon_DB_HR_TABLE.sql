
-- 직원 TABLE
CREATE TABLE EMPLOYEES (
    employee_id VARCHAR2(10) PRIMARY KEY, -- 직원_id
    name VARCHAR2(10) NOT NULL, -- 직원_이름
    email VARCHAR2 (50) NOT NULL, -- 직원_email
    phone_number VARCHAR2 (20) NOT NULL, -- 직원_number
    hiredate VARCHAR (50) NOT NULL -- 직원_고용_날짜
);

select * from EMPLOYEES;
DELETE FROM EMPLOYEES 
WHERE NAME = '1' 
AND EMPLOYEE_ID = '1' 
AND EMAIL = '1' 
AND PHONE_NUMBER = '1998-06-26' 
AND HIREDATE = '1';
commit;

-- JOB TABALE
CREATE TABLE JOBS (
    jobs_id VARCHAR2(10) PRIMARY KEY, -- 직업_id
    jobs_title VARCHAR2 (20) NOT NULL, -- 직업_직함
    jobs_description VARCHAR2 (30), -- 직업_설명
    salary NUMBER(10,2) NOT NULL -- 연봉_정보
);

select * from JOBS;
delete FROM Jobs where JOBS_ID = 1 and JOBS_TITLE = 1 and JOBS_DESCRIPTION = 1 and SALARY = 1;
commit;
select * from JOB_history;
select * from employees;
select * from jobs;

CREATE TABLE JOB_HISTORY (
    employee_id VARCHAR2(10) NOT NULL, -- 직원_id
    start_date DATE NOT NULL, -- 시작_날짜
    end_date DATE NOT NULL, -- 종료_날짜
    jobs_id VARCHAR2(10) NOT NULL, -- 직업_id
    CONSTRAINT job_history_pk PRIMARY KEY (employee_id, start_date), -- primary key 설정
    CONSTRAINT job_history_employee_fk FOREIGN KEY (employee_id) REFERENCES EMPLOYEES (employee_id), -- foreign key 설정
    CONSTRAINT job_history_jobs_fk FOREIGN KEY (jobs_id) REFERENCES JOBS (jobs_id) -- foreign key 설정
);

select * from JOB_HISTORY,jobs,employees ;
select * from JOB_HISTORY;
CREATE TABLE DEPARTMENTS ( 
    department_id VARCHAR2 (50) PRIMARY KEY
    man
);

commit;

