#查找 Person 表中所有重复的电子邮箱。

select email
from person
group by email
having count(email) > 1