# 第二高的薪水

select (select distinct salary from employee order by salary desc limit 1 offset 1) as secondHighestSalary;

select (select distinct salary from employee order by salary desc limit p, 1) as secondHighestSalary