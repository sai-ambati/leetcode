# Write your MySQL query statement below

with cte as(
    select *, 
    count(movie_id) over(partition by user_id) as movie_count,
    date_format(created_at, '%Y-%m') as feb_2020
    -- avg(rating) over(partition by movie_id) as avg_rating
    from MovieRating
),

cte2 as(
    select distinct user_id, movie_count, max(movie_count) over() as max_count
    from cte
),

cte3 as(
    select distinct movie_id, 
    avg(rating) over(partition by movie_id) as avg_rating
    -- round(avg_rating, 2) as avg_rating
    from cte
    where feb_2020 = '2020-02'
),


cte4 as(
    select Users.name as results
    from cte2
    join Users 
    on Users.user_id = cte2.user_id
    where movie_count = max_count
    order by Users.name
    limit 1
), 

cte5 as(
    select Movies.title as results
    from Movies
    join cte3 
    on Movies.movie_id = cte3.movie_id
    order by avg_rating desc, Movies.title
    limit 1
)

select * from cte4
union all
select * from cte5

