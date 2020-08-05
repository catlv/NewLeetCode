package 笔试题.广联达;

import java.util.Scanner;
import java.util.ArrayList;

public class g2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            array.add(sc.nextInt());
        }
        for (int j = 0; j < array.size(); j++) {
            boolean flag = false;
            for (int i = 0; i < array.size() - 1; i++) {
                if (array.get(i) == -1) {
                    break;
                }
                if (array.get(i).equals(array.get(i + 1))) {
                    array.set(i, array.get(i) * 2);
                    array.remove(i + 1);
                    array.add(-1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        for (Integer integer : array) {
            if (integer == -1) {
                break;
            }
            System.out.println(integer + " ");
        }
    }
}

