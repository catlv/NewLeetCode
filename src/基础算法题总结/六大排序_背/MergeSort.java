package 基础算法题总结.六大排序_背;

/**
 * 归并排序，O(nlogn)，O(n)，稳定
 * 思想：归并排序使用的是分而治之的思想，将大问题分解成小的子问题来解决：首先把数组从中间分成前后两部分，然后对它们分别排序，再将排好序的两部分合并在一起，这样整个数组就有序了。
 *
 * 任何情况下时间复杂度都是O(nlogn)，求解过程是：首先假设对n个元素进行归并排序所需要的时间是T(n)，那分解成两个子数组的排序时间就都是 T(n/2)，合并这两个子数组的时间复杂度为 O(n)，所以得到等式 T(n) = 2 * T(n/2) + n，进一步推导可以得到
 * T(n) = 2^k * T(n/2^k) + k * n，当 n/2^k = 1 时，k = logn，T(n) = Cn + nlogn，所以时间复杂度为 O(nlogn)
 *
 * 在合并两个有序数组为一个有序数组时，需要借助额外的存储空间，n/2，n/4，…，1 ，所以空间复杂度为 O(n)。
 */
public class MergeSort {
    public void mergeSort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return;
        }
        merge(a, 0, n - 1);
    }

    public void merge(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        merge(a, l, mid);
        merge(a, mid + 1, r);
        mergeTwo(a, l, mid, r);
    }

    public void mergeTwo(int[] a, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= r) {
            temp[k++] = a[j++];
        }
        for (int m : temp) {
            a[l++] = m;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 2, 4, 1, 6, 7, 8, 10, 9};
        MergeSort t = new MergeSort();
        t.mergeSort(a);
        for (int i : a) {
            System.out.print(i + ",");
        }
    }
}
