select name
from test
group by name
having sum(score) > 240