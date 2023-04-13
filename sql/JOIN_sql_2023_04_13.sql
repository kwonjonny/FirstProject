


-- 2023/04/13
-- Join

select * 
from emp, dept
where emp.deptno = dept.deptno;

select * 
from emp inner join dept
on emp.deptno = dept.deptno
;

select * 
from emp join dept
using (deptno)
;

select deptno 
from emp natural join dept;

-- CROSS JOIN
-- 스키마를 붙이고 결과 행은 모든 경우의 수 => n * m 
-- emp, dept를 crossJoin 한다고 하면 14 * 4 = 56 result
-- emp, dept => 14 * 4 = 56
select e.empno, e.deptno, d.deptno
from emp e, dept d 
where e.deptno=d.deptno
;

select * 
from emp cross join dept;


-- 이름이 SCOOTT인 사람의 부서명을 출력해봅시다
select deptno from emp where ename='SCOTT';
-- 20

select dname from dept where deptno =20;

-- JOIN으로 해결 
select e.ename,d.dname
from emp e, dept d
where e.deptno=d.deptno
        and e.ename='SCOTT' 
;

-- 사원별 급여 등급 표현 
select * from salgrade;

select
e.ename, s.grade, s.losal, e.sal, s.hisal
from emp e, salgrade s
where e.sal between s.losal and hisal
;

-- self join : 자기 자신의 테이블을 조인하는 경우 
-- outer join : 조건에 만족하지 않는 행도 출력을 하는 join
select e.ename, nvl(m.ename, '관리자 없음')
from emp e, emp m 
where e.mgr = m.empno(+)
;

select*
from emp e join emp m 
on e.mgr=m.empno;

select * 
from emp e left outer join emp m
on e.mgr=m.empno;


-- 도서 판매 정보 출력 
select * from 
orders;

-- => orders , customer, book -> 테이블 조인 
select * from
orders o, customer c,  book b
;

select o.orderid, c.name, b.bookname, o.saleprice, o.orderdate
from 
orders o, customer c, book b
where o.custid=c.custid
and o.bookid=b.bookid
;
