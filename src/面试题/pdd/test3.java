package 面试题.pdd;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] array = new int[6][6];

        for (int i = 0; i < 6; i++) {
            char[] c = sc.nextLine().toCharArray();
            for (int j = 0; j < 6; j++) {
                if (c[i] == '#') {
                    array[i][j] = 0;
                } else if (c[i] == '*') {
                    array[i][j] = 1;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (array[i][j] == 0) {
                    if (helper(array, i, j)) {
                        count++;
                    }
                }
            }
        }
        int res = (int) (Math.pow(6, count) % 1000000009);
        System.out.println(res);
    }

    private static boolean helper(int[][] array, int i, int j) {
        if (i < 0 || i >= 6 || j < 0 || j >= 6) {
            return false;
        }
        return helper(array, i - 1, j) && helper(array, i + 1, j) && helper(array, i, j - 1) && helper(array, i, j + 1);
    }
}
