package JZ.topic2;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class T_37_GetNumberOfK {
    //二分查找
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int l = getFirst(array, k);
        int r = getLast(array, k);
        if (l != -1 && r != -1) {
            return r - l + 1;
        }
        return 0;
    }

    private int getFirst(int[] array, int k) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (k <= array[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        //此处要先判断 l < array.length
        //如果先写 array[l] == k，当 l >= array.length，array[l]就越界了
        if (l < array.length && array[l] == k) {
            return l;
        } else {
            return -1;
        }
    }

    private int getLast(int[] array, int k) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (k >= array[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        //要先写 r>=0，如果先写 array[r] == k，当r<0，array[r] 就越界了
        if (r >= 0 && array[r] == k) {
            return r;
        } else {
            return -1;
        }
    }

    //方法二
    //构造k-0.5，k+0.5
    public int GetNumberOfK2(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return helper(array, k + 0.5) - helper(array, k - 0.5);
    }

    private int helper(int[] array, double k) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (k < array[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l; //也可以写成 return r;
    }
}