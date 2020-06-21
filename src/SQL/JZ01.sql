# 查找员工的最晚入职时间

select *
from employees
where hire_date =
      (select max(hire_date) from employees)