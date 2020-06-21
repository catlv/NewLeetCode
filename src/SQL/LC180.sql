# 编写一个 SQL 查询，查找所有至少连续出现三次的数字。

select distinct a.Num AS ConsecutiveNums
from Logs a,
     Logs b,
     Logs c
where a.Id = b.Id - 1
  and b.Id = c.Id - 1
  and a.Num = b.Num
  and b.Num = c.Num