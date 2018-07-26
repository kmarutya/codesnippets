-- links
--  https://www.postgresql.org/docs/9.1/tutorial-window.html
-- https://mode.com/sql-tutorial/sql-window-functions/

SELECT
    start_terminal,
    duration_seconds,
    SUM(duration_seconds) OVER (PARTITION BY start_terminal ORDER BY start_time)AS running_total,
    COUNT(duration_seconds) OVER (PARTITION BY start_terminal ORDER BY start_time) AS running_count,
    AVG(duration_seconds) OVER (PARTITION BY start_terminal ORDER BY start_time)AS running_avg
FROM tutorial.dc_bikeshare_q1_2012
WHERE start_time < '2012-01-08';


SELECT start_terminal,
    start_time,
    duration_seconds,
    ROW_NUMBER() OVER (PARTITION BY start_terminal ORDER BY start_time) AS row_number,
    RANK() OVER (PARTITION BY start_terminal ORDER BY start_time) AS rank,
    DENSE_RANK() OVER (PARTITION BY start_terminal ORDER BY start_time) AS rank,
    LAG(duration_seconds, 1) OVER (PARTITION BY start_terminal ORDER BY duration_seconds) AS lag,
    LEAD(duration_seconds, 1) OVER (PARTITION BY start_terminal ORDER BY duration_seconds) AS lead,
    duration_seconds - LAG(duration_seconds, 1) OVER (PARTITION BY start_terminal ORDER BY duration_seconds) AS difference
FROM tutorial.dc_bikeshare_q1_2012
WHERE start_time < '2012-01-08'



-- window aliasing: WINDOW ntile_window AS (PARTITION BY start_terminal ORDER BY duration_seconds)
SELECT
    start_terminal,
    duration_seconds,
    NTILE(4) OVER ntile_window AS quartile,
    NTILE(5) OVER ntile_window AS quintile,
    NTILE(100) OVER ntile_window AS percentile
FROM tutorial.dc_bikeshare_q1_2012
WHERE start_time < '2012-01-08'
WINDOW ntile_window AS (PARTITION BY start_terminal ORDER BY duration_seconds)
ORDER BY start_terminal, duration_seconds