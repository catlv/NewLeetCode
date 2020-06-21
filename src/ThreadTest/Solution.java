package ThreadTest;

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        if (T >= 1 && T <= 10) {
            while (sc.hasNext() && T > 0) {
                int[] r = new int[6];
                int[] c = new int[6];
                int temp = 1;
                for (int i = 0; i < 6; i++) {
                    r[i] = sc.nextInt();
                    c[i] = sc.nextInt();

                    if (r[i] < c[i]) {
                        temp = r[i];
                        r[i] = c[i];
                        c[i] = temp;
                    }
                }
                for (int i = 0; i < r.length; i++) {
                    for (int j = 0; j < r.length - 1 - i; j++) {
                        if (r[j] < r[j + 1]) {
                            temp = r[j];
                            r[j] = r[j + 1];
                            r[j + 1] = temp;
                            temp = c[j];
                            c[j] = c[j + 1];
                            c[j + 1] = temp;
                        }
                        if (r[j] == r[j + 1] && c[j] < c[j + 1]) {
                            temp = c[j];
                            c[j] = c[j + 1];
                            c[j + 1] = temp;
                        }
                    }
                }
                boolean f = false;
                for (int i = 0; i < 5; i = i + 2) {
                    if (r[i] != r[i + 1] || c[i] != c[i + 1])
                        f = true;
                }
                if (r[0] != r[2] || c[0] != r[4] || c[2] != c[4])
                    f = true;
                T--;
                String res = f ? "IMPOSSIBLE" : "POSSIBLE";
                System.out.println(res);
            }
        }
    }
}
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()) {
//            int[] l = new int[6];//长
//            int[] r = new int[6];//宽
//            int t = 0;
//            for(int i = 0;i<6;i++) {
//                l[i] = in.nextInt();
//                r[i] = in.nextInt();
//                if(l[i]<r[i]){//长放右宽放左
//                    t=l[i];
//                    l[i]=r[i];
//                    r[i]=t;
//                }
//            }
//            for(int i = 0;i<l.length;i++) {//两列各自从大到小排列
//                for(int j = 0;j<l.length-1-i;j++) {//长列
//                    if(l[j]<l[j+1]) {
//                        t = l[j];
//                        l[j] = l[j+1];
//                        l[j+1] = t;
//                        t= r[j];
//                        r[j] = r[j+1];
//                        r[j+1] =t;
//                    }
//                    if(l[j]==l[j+1]&&r[j]<r[j+1]) {//宽列
//                        t= r[j];
//                        r[j] = r[j+1];
//                        r[j+1] = t;
//                    }
//                }
//            }
//            boolean f = true;
//            for(int i=0;i<5;i=i+2){
//                if(l[i]!=l[i+1]||r[i]!=r[i+1])//6面两两对应
//                    f=false;
//            }
//            if(l[0]!=l[2]||r[0]!=l[4]||r[2]!=r[4])//3条公共边
//                f = false;
//            if(f)
//                System.out.println("POSSIBLE");
//            else
//                System.out.println("IMPOSSIBLE");
//        }
//        in.close();
//    }
//}