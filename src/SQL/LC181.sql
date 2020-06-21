#
select a.name as Employee
from Employee a,
     Employee b
where a.ManagerId = b.id
  and a.salary > b.salary