# 查找入职时间倒数第三的员工的所有信息

select *
from employees
order by hire_date desc
limit 2,1