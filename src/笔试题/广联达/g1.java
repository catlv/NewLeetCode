package 笔试题.广联达;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 */
public class g1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int e : arr) {
            minHeap.add(e);
        }
        for (int i = 0; i < m; i++) {
            int s = minHeap.poll();
            s += x;
            minHeap.add(s);
        }
        System.out.println(minHeap.peek());
    }
}
