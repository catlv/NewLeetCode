# 查找各个部门当前(to_date='9999-01-01')领导的当前薪水详情以及其对应部门编号dept_no

select s.*, d.dept_no
from salaries s,
     dept_manager d
where s.to_date='9999-01-01' and d.to_date='9999-01-01' and s.emp_no = d.emp_no


select salaries.*, dept_manager.dept_no
from salaries,dept_manager
where salaries.to_date='9999-01-01'
and dept_manager.to_date='9999-01-01'
and salaries.emp_no = dept_manager.emp_no