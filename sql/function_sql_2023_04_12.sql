
-- 2023_04_12
-- 함수 

desc dual;
select * from dual;

-- 단일행 함수와 / 집합(그룹) 함수 / 
-- 단일행 함수 : 숫자, 문자, 날짜, 변환 
-- abs = 절대값 표현  
select 10, -10, abs(-10), abs(10) from dual;

-- floor : 소수점 아래를 절사 -> 없애준다  
select 2.1, 2.9, floor(2.1), floor(2.9) from dual;

-- round : 지정 위치에서 반올림 처리 
select 1234.567, round(1234.567), round(1234.567, 1), round(1237.567, -2) from dual;

-- trunc : 특정 자리수 아래를 절사
select 1234.567, trunc(1234.567), trunc(1234.567, 1), trunc(1234.567, -2) from dual;

-- mod : 나머지 연산 -> 1/3  2/3  0/3  3/0  -> 0으로 나누는건 안된다 -> java에선 
select mod (1,3), mod(2,3), mod(0,3), mod(13,0) from dual;

-- 문자 함수 
-- lower() -> 소문자로 변경 
-- upper() -> 대문자로 변경 
select 'SCOTT', lower('SCOTT') from dual;
select dname, lower(dname)from dept;
select 'sccot', upper('sccott') from dual;
select initcap('scott') from dual;

-- 문자열을 절사해서 추출 : substr(원본데이터,시작위치), substr(원본데이터, 시작위치, 반환할 문자의 개수)
select '안녕하세요. 손흥민입니다.',
substr('안녕하세요. 손흥민입니다.', 7),
substr('안녕하세요. 손흥민입니다.', 7, 5)
from dual;

-- 문자열의 개수 : length(원본문자열)
select length('안녕하세요. 손흥민입니다.')
from dual;

-- 문자열에서 특정 자리수가 지정하고 자리에 데이터가 없을 때 패턴을 입력
-- 00010
-- -> 10개 자리를 만들고 10을 뒤로보내며 나머지는 7로 채운다 -> lpad 
-- -> 5개 자리를 만만들고 11을 앞으로 보내며 0으로 나머지를 채운다 -> rapd
select '10', lpad('10', 10, '7'), rpad('11', 5, '0')  from dual;

-- -> 5개 자리를 만들어 deptno 에 있는 함수를 불러 안에 있는 숫자 뒤로 보낸뒤 0으로 앞을 채운다 
select deptno, lpad(deptno, 5, '0') from dept;

-- trim() : 공백 제거 
select '     abc     '
, trim('         abc     ')
, trim('  abc              ')
from dual;

-- replace -> 치환 repalce('원본문자', '제거할문자', '선택or공백')
select 'Steven King',
    replace('Steven King', 'Steven', 's.'),
    replace('Steven King', 'Steven', '')
from dual;


-- 날짜 함수 
select sysdate from dual; 

-- 오늘과 23/12/15일과의 차이 
select months_between(sysdate, '23/12/15') from dual;
select months_between('23/12/15', sysdate) from dual;

-- add_months
select add_months(sysdate, 8) from dual;
select add_months(sysdate, -1) from dual;
select add_months(sysdate, -3) from dual;
select add_months(sysdate, -6) from dual;

select next_day(sysdate, 1) from dual;
select last_day(sysdate) from dual;
select round(sysdate) from dual;
-- 오늘 날짜 
select trunc(sysdate) from dual;

-- 변환함수 
-- Date -> CHAR
-- to_char('원본', '패턴')
select sysdate,
        to_char(sysdate, 'YYYY-MM-DD'),
        to_char(sysdate, 'YYYY.MM.DD.'),
        to_char(sysdate, 'YYYY-MM-DD DAY'),
        to_char(sysdate, 'YYYY.MM.DD. HH24:MI:SS ')
from dual;

-- number -> 문자열로 
select 123456789, 
        to_char(123456789, '000000000000'),
        to_char(123456789, '000,000,000,000'),
          to_char(123456789, '999999999'),
           to_char(123456789, '999,999,999'),
            to_char(123456789, 'L999,999,999'),
               to_char(123456, '999,999')
        from dual;

select ename , sal, to_char(sal*1300, 'L999,999,999') as won
from emp;

-- char -> Date 
-- to_date('문자열', '패턴')
select * from emp where hiredate = to_date('1981.02.20', 'YYYY-MM-DD');

insert into emp values(9999, 'SON', 'MANAGER', 7782, '2023-04-12', 4000, null, 10);
select * from emp;
rollback; --> 마지막 commit 시점으로 복귀 

-- char -> number 
-- to_number('문자열', '패턴') => 숫자 타입으로 변경 
select '20,000' - '10,000'
from dual;

select to_number('20,000', '999,999,999') -  to_number('10,000', '99,999') 
from dual;

-- decode 함수 => = 비교 연산 후 결과 출력 하는 함수 switch~case
select ename, deptno,
        decode(deptno,
                10, 'ACCOUNTING', 
                20, 'RESEARCH',
                30, 'SALE',
                40, 'OPERATIONS'
        ) as dname
from emp
order by deptno
;

select ename, job ,sal,
        NVL(decode(job,
        'ANALYST' , sal*1.05,
        'SALESMAN', sal*1.1,
        'MANAGER', sal*1.15,
        'CLERK', sal*1.2
        ),sal) as up,
        NVL(decode(job,
         'ANALYST' , sal*1.05,
        'SALESMAN', sal*1.1,
        'MANAGER', sal*1.15,
        'CLERK', sal*1.2
        ), sal) as upsal
        from emp 
        order by sal;
        
select ename, deptno,
        decode(deptno,
                10, 'ACCOUNTING', 
                20, 'RESEARCH',
                30, 'SALE',
                40, 'OPERATIONS'
        ) as dname,
        case when deptno = 10 then 'ACCOUNTING'
             when deptno=20 then 'RESEARCH'
             when deptno=30 then 'SALES'
             else 'OPERATIONS'
        end as dname2
from emp
order by deptno
;

-- 그룹함수, 집합함수, 집계함수, 다중 행 함수 
-- 하나의 행이 아닌 다중행을 그룹으로 묶어서 처리 
-- sum, avg, count 
-- 급여 총액을 구해보자 
select sum(sal), to_char(sum(sal), 'L999,999')
from emp;

-- 커미션의 총합 
select sum(comm), count(comm), avg(comm)
from emp;
select comm from emp where comm is not null;

-- 평균 급여
select avg(sal), trunc(avg(sal)), round(avg(sal))
from emp;

-- 최대 급여 max(), 최소 급여 min()
select max(sal), min(sal)
from emp;

-- count() => row 개수 
-- 전체 사원의 수 
select count(*)
from emp;
-- 10번 부서의 사원의 수 
select count(*)
from emp where deptno = 10;

-- 부서의 개수 
select count(*) 
from dept;

-- 중복 제거 job의 열 출력 
select distinct job 
from emp;

-- 중복제거 job 개수
select count(distinct(job)) from emp;

-- comm 의 개수 
select count(comm) 
from emp;

select * from emp order by deptno;

-- group by => 행 단위로 그룹핑
select deptno, count(*) as "사원의수" , 
                sum(sal) as "총급여액" , 
                trunc(avg(sal)) as "평균급여액" ,
                max(sal) as "최고급여액" ,
                min(sal) as "최소급여액",
                count(comm) as "커미션을받는사원수"
                from emp 
group by deptno 
-- 그룹의 평균 급여가 2000 이상인 
-- 그룹핑된 데이터의 집합함수 결과를 조건식으로 만들때 
-- 총 급여액이 10000 넘어가는 그룹
having sum(sal) > 10000
order by deptno
;

select job, count(*), trunc(avg(sal)), sum(sal), max(sal), min(sal), max(sal)-min(sal)
from emp
group by job
;