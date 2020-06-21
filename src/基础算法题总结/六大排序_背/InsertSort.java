package 基础算法题总结.六大排序_背;

/**
 * 插入排序，O(n^2)，O(1)，稳定
 * 思想：将数组中的数据分为已排序区间和未排序区间。挨个取未排序区间中的元素，在已排序区间中找到合适的位置进行插入，并保证已排序区间中的元素一直有序。重复这个过程，直到未排序区间中元素为空，算法结束。
 */
public class InsertSort {
    public void insertSort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int j = i - 1; //已排序区间的最后一个数
            int temp = a[i]; //未排序区间的第一个数
            while (j >= 0 && a[j] > temp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 11, 2, 4, 1, 6, 7, 8, 10, 9};
        InsertSort t = new InsertSort();
        t.insertSort(a);
        for (int i : a) {
            System.out.print(i + ",");
        }
    }
}
