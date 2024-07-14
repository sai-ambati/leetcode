# Write your MySQL query statement below

with user_ as(
    select MovieRating.user_id, Users.name, count(*) as noRev
    from MovieRating 
    join Users 
    on MovieRating.user_id = Users.user_id
    group by user_id
    order by noREv desc, Users.name
    limit 1
),

rating as(
    select MovieRating.movie_id, Movies.title, avg(rating) as rat
    from MovieRating
    join Movies
    on MovieRating.movie_id = Movies.movie_id
    where date_format(created_at, '%Y-%m') = '2020-02'
    group by movie_id
    order by rat desc, Movies.title
    limit 1
)
select name as results from user_
union all
select title from rating

