-- EMPLOYEES 테이블 더미 데이터
INSERT INTO EMPLOYEES (employee_id, name, email, phone_number, hiredate)
VALUES 
('E001', '홍길동', 'hong@example.com', '010-1234-5678', '2022-01-01');
('E002', '이영희', 'lee@example.com', '010-3456-7890', '2022-03-01');
('E003', '박민수', 'park@example.com', '010-4567-8901', '2022-04-01');
('E004', '장미경', 'jang@example.com', '010-5678-9012', '2022-05-01');

-- JOBS 테이블 더미 데이터
INSERT INTO JOBS (jobs_id, jobs_title, jobs_description, salary)
VALUES 
('J001', '개발자', '소프트웨어 개발자', 5000000);
('J002', '디자이너', 'UI/UX 디자이너', 4000000);
('J003', '마케터', '디지털 마케터', 4500000);
('J004', '영업사원', '소프트웨어 영업사원', 3500000);

-- JOB_HISTORY 테이블 더미 데이터
INSERT INTO JOB_HISTORY (employee_id, start_date, end_date, jobs_id) VALUES
'E001', '2022-01-01', '2022-02-28', 'J001');
('E002', '2022-03-01', '2022-03-31', 'J002');
('E003', '2022-04-01', '2022-04-30', 'J003');
('E004', '2022-05-01', '2022-05-31', 'J004');