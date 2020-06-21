package 基础算法题总结.六大排序_背;

/**
 * 快速排序，O(nlogn)，O(1)，不稳定
 * 思想：快速排序使用的是分而治之的思想，将大问题分解成小的子问题来解决。首先选择一个基准值，然后遍历数组，将小于基准值的放在左边，大于基准值的放在右边，基准值放在中间，这样数组就被分成了三部分，然后再用递归的思想对小于基准值的部分和大于基准值的部分再进行一次比较划分，每一次可以确定其中一个元素的最终位置。
 *
 * 在理想情况下，每次分区操作都正好把数组分为大小相等的两个子区间，那快排的时间复杂度的求解公式和归并排序的一样，结果也为 O(nlogn)。而在极端情况下，比如数组已经有序时，每次分区都是不均等的，需要进行 n 次分区，这种情况下快排的时间复杂度退化为 O(n^2)
 */
public class QuickSort {
    public void quickSort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return;
        }
        qSort(a, 0, n - 1);
    }

    public void qSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int index = a[l]; //以第一个数为基准值
        int i = l;
        int j = r;
        while (i != j) {
            while (i < j && a[j] >= index) {
                j--;
            }
            if (i < j) {
                a[i++] = a[j];
            }
            while (i < j && a[i] < index) {
                i++;
            }
            if (i < j) {
                a[j--] = a[i];
            }
        }
        a[i] = index;

        qSort(a, l, i - 1);
        qSort(a, i + 1, r);
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 2, 4, 1, 6, 7, 8, 10, 9};
        QuickSort t = new QuickSort();
        t.quickSort(a);
        for (int i : a) {
            System.out.print(i + ",");
        }
    }
}
