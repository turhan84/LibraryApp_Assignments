select * from users;

-- US01-1
-- OPT 1
select count(id) from users;           -- 138  -- ACTUAL
select  count(distinct id) from users; -- 138  -- EXPECTED

-- OPT 2
select id from users;
-- getAllColumnAsList --> List --> size  --> EXPECTED
-- getAllColumnAsList --> Set  --> size  --> EXPECTED

select * from users;


select count(*) from book_borrow where is_returned=0;

select name from book_categories;

select bc.name,count(*) from book_borrow bb
                                 inner join books b on bb.book_id = b.id
                                 inner join book_categories bc on b.book_category_id=bc.id
group by name
order by 2 desc;

select bc.name, count(*) from book_borrow bb
                        inner join books b on bb.book_id = b.id
                        inner join book_categories bc on b.book_category_id = bc.id
                        group by bc.name order by count(*) desc limit 1;


SELECT bc.name, COUNT(*) as count FROM book_borrow bb INNER JOIN books b ON bb.book_id = b.id INNER JOIN book_categories bc ON b.book_category_id = bc.id GROUP BY bc.name ORDER BY count DESC limit 1;