select r.rn,
       r.no,
       r.title,
       r.content,
       r.hit,
       r.reg_date regDate,
       r.user_no userNo,
       r.name userName
from (select rownum rn, 
                   o.no,
                   o.title,
                   o.content,
                   o.hit,
                   o.reg_date,
                   o.user_no,
                   o.name 
            from (select   b.no,
                           b.title,
                           b.content,
                           b.hit,
                           b.reg_date,
                           b.user_no,
                           u.name
                    from board b, users u
                    where b.user_no = u.no
                    order by no desc)o
        )r
where r.rn>=1
and r.rn<=10
;

-- ÄŞ¸¶ ÆÁ ¾Õ¿¡ ºÙ¿©¼­ È¥¼± ¹æÁö ==>  ,name 

