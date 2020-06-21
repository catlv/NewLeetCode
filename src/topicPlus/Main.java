package topicPlus;//package topicPlus;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Main {
//    static int[] index = new int[500];
//    static ArrayList<ArrayList<Integer>> res2 = new ArrayList<>();
//    static int a = 0;
//    static int b = 0;
//    public static int helper(int[] a, int mid, int k, int N) {
//         ArrayList<Integer> temp = new ArrayList<>();
//        int i = 0;
//        int seg = 0;
//        int sum = 0;
//        int j = 0;
//        for (i = 0; i < N; i++) {
//            sum += a[i];
//            if (sum > mid) {
//                sum = a[i];
//                seg++;
//                index[j++] = i;
//                temp.add(i);
//            }
//        }
//        if (seg >= k) {
//            a = index;
//            res2.add(new ArrayList<>(temp));
//            return 0;
//        } else {
//            return 1;
//        }
//    }
//
//    //N个数，分成segment份，low表示N个数里的最大值，high表示N个数的和
//    public static ArrayList<String> value(int[] a, int low, int high, int segment, int N) {
//        ArrayList<String> res = new ArrayList<>();
//        if (low > high) {
//            res2.get()
//            int j = 0;
//            for (int i = 0; i < N; i++) {
//                if (i + 1 == index[j]) {
//                    j++;
//                    res.add(a[i] + " / ");
//                } else {
//                    res.add(String.valueOf(a[i]));
//                }
//            }
//            return res;
//        } else {
//            int mid = (low + high) / 2;
//            if (helper(a, mid, segment, N) == 1) {
//                return value(a, low, mid - 1, segment, N);
//            } else {
//                return value(a, mid + 1, high, segment, N);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int k = sc.nextInt();
//        int[] a = new int[m];
//        int low = Integer.MAX_VALUE;
//        int high = 0;
//        for (int i = 0; i < m; i++) {
//            a[i] = sc.nextInt();
//            high += a[i];
//            low = Math.min(low, a[i]);
//        }
//        ArrayList<String> solve = value(a, low, high, k, m);
//
//        for (String s : solve) {
//            System.out.print(s + " ");
//        }
//    }
//}
//
