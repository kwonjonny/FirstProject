
CREATE TABLE employee (
employee_id VARCHAR2(10) PRIMARY KEY, -- 직원_id
name VARCHAR2(20) NOT NULL, -- 직원_이름
email VARCHAR2(50) NOT NULL, -- 직원_email
phone_number VARCHAR2(20) NOT NULL, -- 직원_전화번호
hire_date DATE NOT NULL, -- 직원_입사일
salary NUMBER(10) NOT NULL -- 직원_급여
); 

-- jobs 테이블
CREATE TABLE jobs (
job_id VARCHAR2(10) PRIMARY KEY, -- 직업_id
job_title VARCHAR2(20) NOT NULL, -- 직업_직함
min_salary NUMBER(10) NOT NULL, -- 최소_급여
max_salary NUMBER(10) NOT NULL -- 최대_급여
);-- employee 테이블


CREATE TABLE job_history (
    job_history_id VARCHAR2(10) PRIMARY KEY,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL
);

drop table employee;
drop table jobs;
drop table job_history;

select * from employee;
select * from jobs;
select * from job_history;

commit;
