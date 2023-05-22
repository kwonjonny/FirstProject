select * from dept ;
select * from tbl_board;

commit;


CREATE TABLE tbl_reply (
    rno NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY,
    bno NUMBER NOT NULL,
    reply VARCHAR2(1000) NOT NULL,
    replyer VARCHAR2(50) NOT NULL,
    replyDate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE
);

ALTER TABLE tbl_reply
ADD CONSTRAINT pk_reply PRIMARY KEY (rno);

CREATE TABLE tbl_board (
    bno NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY,
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(2000) NOT NULL,
    writer VARCHAR2(50) NOT NULL,
    regdate DATE DEFAULT SYSDATE,
    updatedate DATE DEFAULT SYSDATE
);

ALTER TABLE tbl_board
ADD CONSTRAINT pk_board PRIMARY KEY (bno);


ALTER TABLE tbl_reply
ADD CONSTRAINT fk_reply_board FOREIGN KEY (bno) REFERENCES tbl_board (bno);


-- tbl_board 컬럼 추가 
ALTER TABLE tbl_board
ADD file_name VARCHAR2(150);

UPDATE tbl_board SET file_name = 'default_value';

ALTER TABLE tbl_board
MODIFY file_name NOT NULL;

UPDATE tbl_board SET file_name = 'file1';
ALTER TABLE tbl_board RENAME COLUMN file_name TO file1;

commit;

-- select 

-- insert
insert into tbl_board (title,content,writer) values('게스글 테스트1', '게시글 쓰기 테스트1', '테스터');




