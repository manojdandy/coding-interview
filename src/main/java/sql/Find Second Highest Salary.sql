select * from (
select
*,
rank() over(order by salary desc) as rk
from employees) e where e.rk=2
