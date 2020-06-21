package 手写;

public class MergeSort {
    //归并排序
    public void mergeSort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return;
        }
        merge(a, 0, n - 1);
    }

    private void merge(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        merge(a, l, mid);
        merge(a, mid + 1, r);
        mergeTwo(a, l, mid, r);
    }

    private void mergeTwo(int[] a, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = a[i++];
        }
        while (j <= r) {
            tmp[k++] = a[j++];
        }
        for (int m : tmp) {
            a[l++] = m;
        }
    }
}
