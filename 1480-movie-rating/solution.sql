# Write your MySQL query statement below
(
    select u.name as results
    from Users u
    join MovieRating m
    on u.user_id = m.user_id
    group by m.user_id, u.name
    order by count(*) desc, u.name
    limit 1
)
union all
(
    select m.title as results
    from Movies m
    join MovieRating mr
    on m.movie_id = mr.movie_id
    where date_format(created_at, '%Y-%m') = '2020-02'
    group by mr.movie_id
    order by avg(rating) desc, m.title
    limit 1
);
