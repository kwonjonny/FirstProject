-- Individual Sql practice => from

-- 1 DEPT 테이블과 EMP 테이블을 조인해서 부서명, 직원명, 직급, 월급 정보를 출력하는 SQL 쿼리를 작성해보세요.
select *
from emp;

-- 2 EMP 테이블에서 가장 많은 급여(sal)를 받는 직원의 이름, 직급, 급여 정보를 출력하는 SQL 쿼리를 작성해보세요
select ename, job, sal
from emp e
where e.sal = (select max(Sal) from emp);

-- 3 EMP 테이블과 DEPT 테이블을 조인해서 부서명, 직원명, 직급, 월급, 부서위치 정보를 출력하는 SQL 쿼리를 작성해보세요.
select d.dname, e.ename, e.job, e.sal, d.loc
from  dept d join emp e
on e.deptno = d.deptno
;

select * from dept, emp;

-- 5 DEPT 테이블에서 부서별로 직원 수를 출력하는 SQL 쿼리를 작성해보세요.
select d.dname , count(*) as "직원수"
from dept d join emp e 
on d.deptno = e.deptno
group by d.dname
;


