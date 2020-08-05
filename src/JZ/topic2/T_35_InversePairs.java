package JZ.topic2;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class T_35_InversePairs {
    private int count = 0;

    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        merge(array, 0, array.length - 1);
        return count;
    }

    private void merge(int[] array, int l, int r) {
        if (l < r) {  //不能省
            int mid = l + ((r - l) >> 1);
            merge(array, l, mid);
            merge(array, mid + 1, r);
            mergeSort(array, l, mid, r);
        }
    }

    private void mergeSort(int[] array, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            if (array[p1] <= array[p2]) {
                help[i++] = array[p1++];
            } else {
                help[i++] = array[p2++];
                count += mid - p1 + 1;
                count %= 1000000007;
            }
        }
        while (p1 <= mid) {
            help[i++] = array[p1++];
        }
        while (p2 <= r) {
            help[i++] = array[p2++];
        }
        for (int h : help) {
            array[l++] = h;
        }
    }
}
