drop table replyboard;
drop sequence seq_replyboard_no;


CREATE TABLE replyboard (
  no	    NUMBER,
  title 	VARCHAR2(500),
  content   VARCHAR2(4000),
  hit       NUMBER,
  reg_date  DATE,
  user_no   NUMBER,
  group_no  NUMBER,
  order_no  NUMBER,
  depth  NUMBER,
  PRIMARY KEY(no),
  CONSTRAINT c_replyboard_fk FOREIGN KEY (user_no) 
  REFERENCES users(no)
);


CREATE SEQUENCE seq_replyboard_no
INCREMENT BY 1 
START WITH 1 
NOCACHE ;


insert into replyboard
values (seq_replyboard_no.nextval, '글제목1', '글본문1', 0, sysdate, 1, seq_replyboard_no.currval, 1, 0);

insert into replyboard
values (seq_replyboard_no.nextval, '글제목2', '글본문2', 0, sysdate, 1, seq_replyboard_no.currval, 1, 0);

insert into replyboard
values (seq_replyboard_no.nextval, '글제목3', '글본문3', 0, sysdate, 1, seq_replyboard_no.currval, 1, 0);

insert into replyboard
values (seq_replyboard_no.nextval, '글제목4', '글본문4', 0, sysdate, 1, seq_replyboard_no.currval, 1, 0);


-- 2번글 댓글
insert into replyboard
values (seq_replyboard_no.nextval, '글제목2-1', '글본문2-1', 0, sysdate, 1, 2, 2, 1);  


-- 2-1번글 댓글
insert into replyboard
values (seq_replyboard_no.nextval, '글제목2-1-1', '글본문2-1-1', 0, sysdate, 1, 2, 3, 2);  


commit;




select * from replyboard;



select  r.no,
        r.title,
        r.content,
        r.hit,
        r.reg_date regDate,
        r.user_No userNo,
        u.name userName,
        r.group_no groupNo,
        r.order_no orderNo,
        r.depth
from replyboard r, users u
where r.user_No = u.no
order by groupNo desc,
         orderNo asc;
         
         
relect  r.no,
        r.title,
        r.content,
        r.hit,
        r.reg_date regDate,
        r.user_No userNo,
        u.name userName,
        r.group_no groupNo,
        r.order_no orderNo,
        r.depth
from replyboard r, users u
where r.user_No = u.no
and r.no = 5;        
         
         
         
