# 合并两个表

select firstName, lastName, city, state
from person
       left join address
                 on person.personId = address.personId
