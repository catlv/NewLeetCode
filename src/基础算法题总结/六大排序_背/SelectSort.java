package 基础算法题总结.六大排序_背;

/**
 * 选择排序，O(n^2)，O(1)，不稳定
 * 思想：将数组中的数据分为已排序区间和未排序区间，每次从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
 */
public class SelectSort {
    public void selectSort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; //初始化minIndex为未排序区间的第一个值，i位置为未排序区间的起点
            for (int j = i + 1; j < n; j++) { //i+1到n-1，为未排序区间除起点外剩余的范围
                if (a[j] < a[minIndex]) { //小于，是升序；大于，是降序
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 2, 4, 1, 6, 7, 7, 8, 10, 9};
        SelectSort t = new SelectSort();
        t.selectSort(a);
        for (int i : a) {
            System.out.print(i + ",");
        }
    }
}
