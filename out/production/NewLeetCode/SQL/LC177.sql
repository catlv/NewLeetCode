# 第n高的薪水

select (select distinct salary from employee order by salary desc limit 1 offset p)