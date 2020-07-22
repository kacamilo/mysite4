drop table gallery;
drop sequence seq_gallery_no;

create table gallery (
    no              number,
    user_no         number,
    comments        varchar2(1000),
    filePath        varchar2(500),
    orgName         varchar2(200),
    saveName        varchar2(500),
    fileSize        number,
    PRIMARY KEY(no),
    CONSTRAINT FK_GALLERY_USER_NO FOREIGN KEY (user_no)
    REFERENCES users(no)
);

create Sequence seq_gallery_no
increment by 1
start with 1;

insert into gallery
values(SEQ_GALLERY_NO.nextval, '2', 'じ闌じ闌', '仆仄予', '今內今內', '內今', '1000');
select no,
       user_no,
       comments,
       filePath,
       orgName,
       saveName,
       fileSize
from gallery;

select  g.no, 
        g.user_no, 
        g.saveName, 
        u.name
    from 
        gallery g, users u
    where 
        g.user_no = u.no;

select *
from gallery;
