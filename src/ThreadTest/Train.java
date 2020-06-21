package ThreadTest;


import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 火车站台所运营的线路路，最大的一个是多少？
 */
public class Train {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q;
        int z;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            q = in.nextInt();
            z = in.nextInt();
            for (int j = q; j < z; j++) {
                if (map.get(j) == null) {
                    map.put(j, 1);
                } else {
                    int value = map.get(j);
                    value++;
                    map.put(j, value);
                }
            }
        }
        Collection<Integer> c = map.values();
        int x = Collections.max(c);
        System.out.println(x);
    }
}
