
-- 2023 . 04 . 11
-- select

-- 로그인 한 사용자 소유하고 있는 테이블의 정보

select * from tab;

-- 테이블 정보 확인
DESCRIBE emp;

desc dept;

-- 데이터 추출하는 질의어 : select 
-- select 컬럼 이름, 컬럼 이름 , 컬럼 이름 ... from 테이블이름 (VIEW 도 사용 가능)
-- select * from 테이블이름;

select * from dept;
SELECT * FROM DEPT;

-- 특정 컬럼의 데이터만 검색 하는 것 
select dname, deptno, loc
from dept 
;

-- select 구문의 프레젠테이션 영역에 컬럼 테이블이 가지고있는 컬럼 뿐 아니라 연산의 결과를 새로운 컬럼으로 출력 가능 
select sal, sal+100 , sal -100 , sal *  10 , sal / 2 from emp;
select sal + 100 from emp;
select sal - 100 from emp;
select sal * 10 from emp;
select sal / 2 from emp;

-- 사원 테이블에서 사원의 이름과 급여, 연봉 계산 결과를 출력 가능,
-- 연봉의 계산은 월 급여 * 12 상여금 + 500 
select ename, sal, sal*12+500
from emp;

-- 상여금 계산 -> sal * 12 + comm
select ename, comm, nvl(comm, 0), sal, sal * 12 + nvl(comm,0)
from emp;

-- 컬럼의 이름에 별칭 부여 
-- 컬럼 뒤에 as 라는 키워드를 쓰고 별칭을 부여한다 
select ename, comm, nvl(comm, 0)as comm1, sal, sal * 12 + nvl(comm,0) as yearSal
from emp;

-- 문자열의 연산 문자열을 붙여준다 -> 문자열 || 문자열
select ename || ' is a ' || job
from emp;

-- select [distinct] from ... 
-- 중복값을 제거 하고 값을 하나만 출력
select deptno  
from emp;

select distinct deptno  
from emp;

select distinct job  
from emp;

-- 원하는 행 검색 
-- where 절 사용 
-- select ... from ... where 조건식;
select * from emp where sal >= 3000;
-- 급여가 3000이상인 사원의 정보 리스트 

-- = : 컬럼의 데이터 를 같다 비교 
-- 10번 부서의 소속된 사원들의 정보를 출력해보자 
select * 
from emp
where deptno=10
;

-- 다음은 이릉이 Ford인 사원의 번호 (ENPNO)과 사원이름(ENAME)과 급여(SAL)을 출력
-- 문자열 비교 => I작은 따움표 사용
select * 
from emp
where Ename = 'FORD'
;

-- 날짜를 비교할때도 작은 따움표 사용 
select *
from emp
where hiredate > '81/12/03'
;

-- 논리연산자 : And OR NOT 
-- 10번부서의 매니저가 누구인지 찾아보자 
-- 10번부서의 매니저 정보를 출력 
select * from emp where deptno = 10 and job = 'MANAGER';
select * from emp where deptno = 10 or job = 'MANAGER';

select * from emp where deptno = 20 or deptno = 30 or deptno = 40;
select * from emp where not deptno = 10;
select * from emp where  deptno <> 10;
select * from emp where deptno != 10;

-- 2000에서 3000 사이의 급여를 받는 사원
select * from emp where sal>=2000 and sal<=3000;

-- 범위 연산자 between A and B => A이상 B이하
select * from emp where sal between 2000 and 3000;

-- 범위 연산자의 연산은 날짜도 가능 : 날짜는 작은 따움표로 저으이 
-- 1987년에 입사한 사원 -> '1987/01/01' ~ '87/12/31'
select * from emp WHERE hiredate between '80/01/01' and '87/12/31';

-- 1891년을 제외한 나머지 년도
select * from emp where hiredate not between '80/01/01' and '87/12/31';

-- 10번, 20번, 30번 부서에 소속한 사원의 정보를 출력 
select * from emp where deptno = 10; or ; deptno = 20; or deptno = 30;

-- in(값1, 값2, ... 여러개) : or 의 연산을 간단하게 처리 
-- 컬럼 = 값1 or 컬럼2 = 값2 ...
select * from emp where deptno in(10, 20, 30);

-- deptno 중 10,20번 부서를 포함하지 않는것
select * from emp where deptno not in(10, 20);

-- 패턴 검색 : 문자열의 패턴 ->  컬럼 LIKE '패턴'
-- 컬럼 Like '패턴'
-- 패턴 형식 : % -> 0개 이상~ '%java%' => java 문자열을 포함하는 문자열 
-- _한자리  __두자리 ___세자리 => __A 앞 두자리는 어떤 문자가 와도 상관없고 A로 끝나는 세 자리 문자열

-- F로 시작하는 이름의 사원 리스트
select * from emp where ename like 'S%';

-- 이름에 A 를 포함하는 사원 리스트 
select * from emp where ename like '%A%';

-- 이름이 N 으로 끝나는 사원의 리스트 
select * from emp where ename like '%N';

-- 사원 이름중 두번째 문자가 A 인 사원 리스트
select * from emp where ename like '_A%';

-- 이름에 A 를 포함하지 않는 사원 리스트 
select * from emp where ename not like '%A%';

-- NULL 여부를 판단하는 is null / is not null
-- 커미션이 등록되지 않은 사원 리스트 => comm 이 null 인 사원 
select * from emp where comm is null;

-- 커미션이 등록되어 있는 사원 리스트 => comm 이 not null 인 사원
select * from emp where comm is not null;

-- 커미션을 받지 않는 사원 리스트 
select * from emp where comm=0 or comm is null;

-- 커미션을 받는 사원의 리스트 
select * from emp where not (comm=0 or comm is null);
select * from emp where comm > 0 and comm is not null;

-- select 의 출력 결과의 정렬 : 오름차순 asc, 내림차순 desc
-- select ... from ... where ... order by 컬럼이름 { asc, desc }

-- 급여순으로(오름차순) 사원 리스트 출력 
select * from emp order by sal asc;

-- 급여순으로(내림) 사원 리스트 출력 
select * from emp order by sal desc;

-- 문자 정렬
-- 이름 순
-- 오름 차순 -> 사전 순서 
select * from emp order by ename asc;

-- 내림 차순
select * from emp order by ename desc;

-- 날짜 
-- 입사일 빠른 순서 : 오름 차순
select * from emp order by hiredate;

-- 최근 입사일 순서 : 내림차순
select * from emp order by hiredate desc;

-- 급여 순으로 정렬
select * from emp order by sal;

select * from emp order by sal, ename desc;

commit;