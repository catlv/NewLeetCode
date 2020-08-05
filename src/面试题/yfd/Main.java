package 面试题.yfd;

/**
 * 4
 * 1 4
 * 1 2
 * 2 3
 * 3 4
 *
 * 2
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Line> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            Line line = new Line(s, e);
            list.add(line);
        }
        int res = getNum(list);
        System.out.println(res);
    }

    private static int getNum(ArrayList<Line> list) {
        int max = Integer.MIN_VALUE;
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            int sum = 1;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).start < list.get(i).end) {
                    sum++;
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}

class Line implements Comparable<Line> {
    public int start;
    public int end;

    public Line(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Line o) {
        return this.end - o.end;
    }
}
