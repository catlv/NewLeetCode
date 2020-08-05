package pdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        ArrayList<Line> list1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Line line = new Line(x, y);
            list1.add(line);
        }
        ArrayList<Line> list2 = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Line line = new Line(x, y);
            list2.add(line);
        }
        Collections.sort(list1);
        Collections.sort(list2);
        int res = Integer.MAX_VALUE;
        if (t == 0) {
            System.out.println(0);
        } else if (t < 0) {
            System.out.println(-1);
        } else {
            for (Line value : list1) {
                for (Line line : list2) {
                    int a = value.y;
                    int b = line.y;
                    if (a >= t) {
                        res = Math.min(res, value.x);
                    } else if (b >= t) {
                        res = Math.min(res, line.x);
                    } else {
                        if (a + b < t) {
                            continue;
                        } else if (a + b >= t) {
                            int c = value.x;
                            int d = line.x;
                            res = Math.min(res, c + d);
                        }
                    }
                }
            }
            if (res == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(res);
            }
        }
    }
}

class Line implements Comparable<Line> {
    public int x;
    public int y;

    public Line(int start, int end) {
        this.x = start;
        this.y = end;
    }

    @Override
    public int compareTo(Line o) {
        return this.y - o.y;
    }
}
