
--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
--(1) 도서번호가1인도서의이름
SELECT bookname FROM Book WHERE bookid = 1;
--(2) 가격이20,000원이상인도서의이름
 SELECT bookname FROM Book WHERE price >= 20000;

--2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.
--(3) 모든고객의이름, 주소
SELECT name, address FROM Customer;

--(4) 2014년7월4일~7월7일사이에주문받은도서의주문번호
SELECT orderid FROM Orders WHERE orderdate BETWEEN TO_DATE('2014-07-04', 'YYYY-MM-DD') AND TO_DATE('2014-07-07', 'YYYY-MM-DD');

--(5) 2014년7월4일~7월7일사이에주문받은도서를제외한도서의주문번호
 SELECT orderid FROM Orders WHERE orderdate NOT BETWEEN TO_DATE('2014-07-04', 'YYYY-MM-DD') AND TO_DATE('2014-07-07', 'YYYY-MM-DD');
 
--(6) 성이‘김’씨인고객의이름과주소
SELECT name, address FROM Customer WHERE name LIKE '김%';

--(7) 성이‘김’씨이고이름이‘아’로끝나는고객의이름과주소
SELECT name, address FROM Customer WHERE name LIKE '김%아';