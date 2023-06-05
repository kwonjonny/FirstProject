
CREATE TABLE STUDENT ( 
id varchar2(255) not null,
password varchar(255) not null
);

select * from  student;
drop table student;
commit;


select * from USERS;

-- 회원 테이블 
CREATE TABLE USERS (
  username VARCHAR2(255) NOT NULL,
  email VARCHAR2(255) NOT NULL,
  id VARCHAR2(255) NOT NULL,
  password VARCHAR2(255) NOT NULL,
  passwordChangeInterval NUMBER NOT NULL,
  last_password_change DATE NOT NULL,
  CONSTRAINT users_pk PRIMARY KEY (id)
);

-- 회원의 인증상태 추가 -> default값 N 
ALTER TABLE USERS ADD isVerified CHAR(1) DEFAULT 'N' NOT NULL;

-- 회원의 활성상태 추가 -> defualt값 ACTIVE
-- 회원의 비활성상태 -> INACTIVE
ALTER TABLE USERS ADD (
  status CHAR(10) DEFAULT 'ACTIVE' NOT NULL
);



--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------

select * from tbl_board;

-- 게시판 테이블 생성
CREATE TABLE tbl_board (
    bno NUMBER,                      -- 게시물 번호 (자동 증가)
    title VARCHAR2(200) NOT NULL,    -- 제목
    content VARCHAR2(3000) NOT NULL, -- 내용
    regdate DATE DEFAULT SYSDATE,    -- 등록일시 (기본값: 현재 날짜 및 시간)
    updatedate DATE DEFAULT SYSDATE, -- 수정일시 (기본값: 현재 날짜 및 시간)
    user_id VARCHAR2(255),           -- 사용자 아이디 (외래키)
    PRIMARY KEY (bno),               -- 기본키 설정
    FOREIGN KEY (user_id) REFERENCES USERS(id)  -- 외래키 설정 (사용자 테이블의 id와 연결)
);

-- 게시물 번호 자동 증가를 위한 시퀀스 생성
CREATE SEQUENCE seq_board
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE
    NOCACHE;

-- 게시물 번호 자동 증가를 위한 트리거 생성
CREATE TRIGGER trg_board_bno
BEFORE INSERT ON tbl_board
FOR EACH ROW
BEGIN
    SELECT seq_board.NEXTVAL INTO :new.bno FROM dual;
END;
/

ALTER TABLE tbl_board
MODIFY (regdate DATE DEFAULT SYSDATE, updatedate DATE DEFAULT SYSDATE);

ALTER TABLE tbl_board ADD filename VARCHAR(255);
ALTER TABLE tbl_board DROP COLUMN filename;
commit;


--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------

select * from tbl_board;

SELECT * FROM tbl_board ORDER BY bno ASC;


UPDATE USERS
SET status = 'ACTIVE'
WHERE username = '김선제';






