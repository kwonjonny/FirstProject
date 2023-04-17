

-- create table 2023/04/17
-- ddl test

create table ddl_test(
    -- 컬럼들을 정의 --
    no number(3),
    name varchar(10),
    birth date default sysdate
);

-- create table 테이블이름 (
-- 컬럼이름 , type (제약조건),
-- 컬럼이름 , type (제약조건),
-- 컬럼이름 , type (제약조건),
-- 컬럼이름 , type (제약조건)
-- );


create table ddl_test(
    -- 컬럼들을 정의 --
    no number(3),
    name varchar(10),
    birth date default sysdate
);

desc ddl_test;

-- 사원번호, 사원이름, 급여 3개의 칼럼으로 구성된 emp01 테이블을 생성해봅시다
create table emp01 (
    empno number(4),
    ename varchar2(10),
    sal number(7,2)
);

desc emp01;

insert into emp01 (empno, ename, sal) values(1111,'SON',1000);
select * from emp01;

-- 서브쿼리를 이용해서 기존 테이블의 구조로 테이블을 생성, 데이터도 저장, 제약조건은 복사되지 않는다 
create table emp02
as select * from emp;
desc emp02;
desc emp;
select * from emp02;

-- 원하는 컬럼만 또는 원하는 로우만 선택해서 테이블을 생성 
create table emp03
as select empno, ename, job, hiredate from emp
;
desc emp03;
select * from emp03;

-- 30 번 부서의 정보만 가지는 새로운 테이블 생성
select empno, ename, job from emp where deptno = 30;

create table emp04
as select empno, ename, job from emp where deptno = 30;

select * from emp04;

-- 데이터 필요 없이 스키마만 복사 
select * from emp where 1=0;
create table emp05 
as select * from emp where 1=0;

select * from emp05;
desc emp05;

-- 테이블의 변경 : 테이블의 저장구조 (스키마의 구조: 컬럼들의 집합) 가 변경
-- 컬럼 변경 (테이블에 컬럼을 추가, (테이블에 있는 컬럼을 삭제, 컬럼의 내용이나 이름을 수정)

-- 테이블의 변경
-- alter table -> [add, modify, drop column] ()

-- emp01 테이블에 job 컬럼을 추가한다
desc emp01;
alter table emp01 add (job varchar2(9));
select * from emp01;

-- 직급(job) 칼럼을 최대 30글자까지 저장할 수 있게 변경해 보도록 하자
desc emp01;

alter table emp01 modify(job varchar2(20) not null);

alter table emp01 modify(job varchar2(50));

select * from emp01;

delete from emp01 where empno=1111;
commit;

-- emp01 테이블에서 job컬럼을 삭제
alter table emp01 drop column job;

-- 테이블 객체의 삭제 
-- drop table 테이블 이름 => 스키마 삭제와 저장데이터 
-- DDL : 자동 commit, DML 작업중 DDL 작업은 신중하게 

-- emp01 테이블 삭제해보자
drop table emp01;
desc emp01;
select * from emp01;

-- 테이블의 모든 행을 삭제 : trauncate table 테이블이름
select * from emp02;
truncate table emp02;

select * from emp03;
delete from emp03;
rollback;

-- ddl_test => test 이름 변경 
rename ddl_test to test;
desc ddlt_test;
desc test;

-- 제약조건의 필요성
insert into dept values(10,'test','test');

-- not null 제약조건 : 설정한 컬럼에 null 값 빙력을 금지하는 제약조건
-- 컬럼 수준에서만 정의가 가능 
drop table emp02;
-- 사원테이블 생성 : 사원번호, 사원이름, 직급, 부서명
-- 사원번호, 사원이름에 not null 제약조건을 설정
create table emp02(
    empno number(4) not null,
    ename varchar2(10) not null,
    job varchar2(9),
    deptno number(2)
);
insert into emp02 values(1111,null,'MANAGER',30);
insert into emp02 (job,deptno) values ('MANAGER', 10);

-- emp03 생성 : 사원번호, 사원이름, 사원직급, 부서번호
-- empno : unique 
-- ename : not null
create table emp03(
    empno number(4) unique,
    ename varchar2(10) not null,
    job varchar2(9),
    deptno number(2)
);

desc emp03;
-- unique : 컬럼 내부에 중복되는 데이터가 있으면 입력 실패 , 수정 실패 
insert into emp03 values (1111,'KING','MANAGER',10);
insert into emp03 values (1112,'SON','MANAGER',20);
select * from emp03;

-- not null unique 함께 사용
create table emp01(
    empno number(4) constraint PK_EMP01_EMPNO primary key,
    ename varchar2(10) constraint NN_EMP01_ENAME not null,
    job varchar2(9) constraint UK_EMP01_JOB unique,
    deptno number(2)
);
insert into emp01 values(null,'KING','MANAGER',40);

desc emp01;

select * from emp01;

-- 기본키 제약 조건
-- 컬럼 옆에 primary key 키워드 사용 
create table emp01(
    empno number(4) constraint PK_EMP01_EMPNO primary key,
    ename varchar2(10) constraint NN_EMP01_ENAME not null,
    job varchar2(9) constraint UK_EMP01_JOB unique,
    deptno number(2)
);
insert into emp01 values(null,'KING','MANAGER',40);

-- 왜래키 제약조건 
create table emp01(
    empno number(4) constraint PK_EMP01_EMPNO primary key,
    ename varchar2(10) constraint NN_EMP01_ENAME not null,
    job varchar2(9) constraint UK_EMP01_JOB unique,
    sal number (7,2) check(sal between 800 and 5000),
    gender char(1) constraint CK_EMP01_GENDER check(gender in ('M', 'F')),
    deptno number(2) constraint FK_EMP_01_DEPTNO references dept (deptno),
    hiredate date default sysdate
);
drop table emp01;
insert into emp01 values(1112,'KING','MANAGER',1500,'F',40,sysdate);
insert into emp01 (empno,ename,job,sal,gender,deptno)
values(1112, 'SON', 'FREE', 3000, 'M', 40);

select * from emp01;
-- check : 범위, 값을 확인 후 입력 또는 수정 

-- 테이블에서의 제약 조건 

-- 왜래키 제약조건 
create table emp01(
    empno number(4),
    ename varchar2(10) constraint NN_EMP01_ENAME not null,
    job varchar2(9),
    sal number (7,2) check(sal between 800 and 5000),
    gender char(1) constraint CK_EMP01_GENDER check(gender in ('M', 'F')),
    deptno number(2),
    hiredate date default sysdate,
    constraint PK_EMP01_EMPNO primary key (empno),
    constraint UK_EMP01_JOb unique (job),
    constraint FK_EMP01_DEPTNO FOREIGN KEY (deptno) references dept(deptno)
);
