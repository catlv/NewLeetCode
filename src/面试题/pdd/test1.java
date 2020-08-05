package 面试题.pdd;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            k -= array[i];
            if (k == 0) {
                System.out.println("paradox");
                return;
            }
            if (k < 0) {
                count++;
                k = -k;
            }
        }
        System.out.println(k + " " + count);
    }
}
