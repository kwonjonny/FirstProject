
-- Individual Sql practice => select
--1 모든 사원의 사번, 이름, 급여 정보를 출력하는 쿼리
select empno, ename, job, mgr, hiredate, sal, comm, deptno
from emp;

--2 emp 테이블에서 deptno가 20인 사원의 ename, job, sal 정보를 출력하는 쿼리를 작성해보세요.
select ename, job, sal
from emp
where deptno = 20;

--3 emp 테이블에서 sal이 3000 이상인 사원의 ename, job, sal 정보를 출력하는 쿼리를 작성해보세요.
select ename, job, sal
from emp
where sal <= 3000;

--4 emp 테이블에서 hiredate가 1981년인 사원의 ename, job, hiredate 정보를 출력하는 쿼리를 작성해보세요.
select ename, job, hiredate
from emp
where hiredate between '1981-01-01' and '1981-12-31';

--5 emp 테이블에서 1981년 1월 1일부터 1981년 12월 31일까지 입사한 사원의 ename, job, hiredate 정보를 출력
select ename, job, hiredate 
from emp
where hiredate between '1981-01-01' and '1981-12-31';

--6 emp 테이블에서 job이 'MANAGER'인 사원의 ename, job, sal 정보를 출력하는 쿼리를 작성해보세요.
select ename,job,sal
from emp
where job = 'MANAGER';

--7 emp 테이블에서 사원들의 사번, 이름, 부서번호, 부서이름을 출력하는 쿼리를 작성하세요.
select empno,ename,deptno
from emp;

--8 emp 테이블에서 sal이 2000 이하이고 job이 SALESMAN인 사원의 ename, job, sal 정보를 출력하는 쿼리를 작성해보세요.
select ename,job,sal 
from emp
where sal <=2000 and job = 'SALESMAN';

--9 emp 테이블에서 deptno가 10, 20, 30인 사원의 ename, job, deptno 정보를 출력하는 쿼리를 작성해보세요.
select ename,job,deptno
from emp
where deptno = 10 or deptno = 20 or deptno = 30;

--10 emp 테이블에서 sal이 1000 이하이거나 comm이 500 이상인 사원의 ename, job, sal, comm 정보를 출력하는 쿼리를 작성해보세요.
select ename,job,sal,comm
from emp
where sal <=1000 or comm <= 500;

-- 11 emp 테이블에서 ename이 'S'로 시작하는 사원의 ename, job, sal, comm 정보를 출력하는 쿼리를 작성해보세요.
select ename,sal,comm
from emp
where ename LIKE 's__';

-- 12 emp 테이블에서 hiredate가 1981년인 사원의 ename, job, hiredate 정보를 출력하는 
-- 쿼리를 작성해보세요. (BETWEEN을 사용하지 않고 작성해보세요.)
select ename,job,hiredate
from emp
where hiredate >= '1981-01-01' and hiredate <= '1981-12-31';

-- 13 emp 테이블에서 job이 'CLERK', 'SALESMAN', 'ANALYST' 중 하나이고,
-- sal이 2000 이상인 사원의 ename, job, sal 정보를 출력하는 쿼리를 작성해보세요.
select ename,job,sal
from emp 
where sal <= 2000;

-- 14 emp 테이블에서 job이 CLERK이고 sal이 1000 이상인 사원의 ename, job, sal 정보를 출력하는 쿼리를 작성해보세요.
select ename,job,sal
from emp
where sal <=1000 and job= 'CLERK';

-- 15 emp 테이블에서 job이 'SALESMAN'이고 sal이 1500 이상인 사원의 ename, job, sal 정보를 출력하는 쿼리를 작성해보세요.
select ename,job,sal
from emp
where job = 'SALESMAN';

-- 16 emp 테이블에서 직급(job)이 "MANAGER"이고, 급여(sal)가 2500 이상인 
-- 사원의 이름(ename), 직급(job), 급여(sal) 정보를 출력하는 쿼리를 작성해보세요.
select ename,job,sal
from emp 
where job = 'MANAGER' and sal <= 2500;

-- 17 직급이 'SALESMAN'인 사원들 중에서 1981년 이후에 입사한 사원의 이름, 입사일, 급여를 출력하는 쿼리를 작성해보세요.
select ename,hiredate,sal
from emp
where job = 'SALESMAN' and hiredate <= '1981-12-31';

-- 18 emp 테이블에서 job이 SALESMAN인 사원들의 이름, 부서 번호, 급여, 부서 이름, 위치를 출력하는 쿼리를 작성해보세요.
select ename,deptno,sal,empno
from emp
where job = 'SALESMAN';

-- 19  emp 테이블에서 sal이 3000 이상인 사원의 ename, job, sal 정보를 출력하는 쿼리
select ename,job,sal
from emp
where sal <= 3000;

-- 20 emp 테이블에서 hiredate가 1981년인 사원 중에서, 
--job이 MANAGER인 사원의 ename, job, hiredate 정보를 출력하는 쿼리를 작성하세요.
select ename,job,hiredate
from emp
where job = 'MANAGER'; and hiredate between = '1981.12.31' and '1981.01.01';

-- 21  고객(Customer) 테이블에서 주소(address)가 
-- '대한민국 서울'인 고객들의 고객번호(custid), 이름(name), 주소(address)를 출력하세요. 
select custid, name, address
from customer
where address = '대한민국 서울';

-- 22 고객(Customer) 테이블에서 전화번호(phone)가 NULL인 고객들의 고객번호(custid), 이름(name), 전화번호(phone)를 출력하세요.
select custid, name, phone
from customer
where phone is null;

-- 23 책(Book) 테이블에서 가격(price)이 10000원 이하인 책들의 
-- 책번호(bookid), 책이름(bookname), 출판사(publisher), 가격(price)를 출력하세요.
select bookid, bookname, publisher, price
from book
where price <= 10000;

-- 24. Orders 테이블에서 판매금액(saleprice)이 
-- 10000원 이상인 주문들의 주문번호(orderid), 고객번호(custid), 
-- 책번호(bookid), 판매금액(saleprice), 주문일(orderdate)를 출력하세요.
select bookid, saleprice, orderdate
from orders 
where saleprice <= 10000;

-- 25. Orders 테이블에서 판매금액(saleprice)이 10000원 이상이고 주문일(orderdate)이 
--2014년 7월 1일 이후인 주문들의 주문번호(orderid), 고객번호(custid), 책번호(bookid),
--판매금액(saleprice), 주문일(orderdate)를 출력하세요.
select orderid, custid, bookid, saleprice, orderdate
from orders 
where orderdate <= '2014.07.01'; and price <= 10000;

-- 26.  EMP 테이블에서 직업이 "SALESMAN"인 사원의 이름, 직업, 급여 정보를 조회
select ename, job, sal
from emp
where job = 'SALESMAN';
