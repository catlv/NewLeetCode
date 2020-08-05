package JZ_LC;

/**
 * 不能用dp，会超时
 * 需要用归并排序来解决
 */
public class T_51_数组中的逆序对 {
    int count = 0;

    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        merge(nums, 0, nums.length - 1);
        return count;
    }

    private void merge(int[] nums, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            merge(nums, l, mid);
            merge(nums, mid + 1, r);
            mergeSort(nums, l, mid, r);
        }
    }

    private void mergeSort(int[] nums, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            if (nums[p1] <= nums[p2]) {
                tmp[i++] = nums[p1++];
            } else {
                tmp[i++] = nums[p2++];
                count += mid - p1 + 1;
            }
        }
        while (p1 <= mid) {
            tmp[i++] = nums[p1++];
        }
        while (p2 <= r) {
            tmp[i++] = nums[p2++];
        }
        for (int t : tmp) {
            nums[l++] = t;
        }
    }
}
