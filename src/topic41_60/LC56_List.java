package topic41_60;

import java.util.ArrayList;
import java.util.List;

public class LC56_List {
    public List<Interval> merge(List<Interval> arrs) {
        List<Interval> res = new ArrayList<>();
        if (arrs == null || arrs.size() == 0) {
            return res;
        }
        //对int排序用Arrays.sort，对List排序用List.sort
        arrs.sort((a, b) -> a.start - b.start);

        int start = arrs.get(0).start;
        int end = arrs.get(0).end;

        for (Interval arr : arrs) {
            if (arr.start <= end) {
                end = Math.max(arr.end, end);
            } else {
                res.add(new Interval(start, end));
                start = arr.start;
                end = arr.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
