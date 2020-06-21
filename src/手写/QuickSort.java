package 手写;

public class QuickSort {
    public static void quickSort(int[] a, int first, int last) { //last 为 a.length - 1
        if (first >= last || a == null || a.length <= 1) {
            return; //每一趟结束的条件
        }
        int i = first;
        int j = last;
        int index = a[first]; // 以第一个数49作为基准
        while (i != j) {
            //从右往左扫描，找到第一个比49小的元素，并交换
            while (i < j && a[j] >= index) {
                j--;
            }
            //找到之后交换
            if (i < j) {
                a[i++] = a[j];
            }
            //从左往右扫描，找到第一个比49大的元素，并交换
            while (i < j && a[i] <= index) {
                i++;
            }
            //找到之后交换
            if (i < j) {
                a[j--] = a[i];
            }
        }
        a[i] = index;

        quickSort(a, first, i - 1); // 对低子表进行递归排序
        quickSort(a, i + 1, last); // 对高子表进行递归排序
    }
}
