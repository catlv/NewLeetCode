package topic81_100;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * System.arraycopy(要复制的数组，复制起点下标，复制到的数组，起点下标，要复制数组的长度);
 */
public class LC88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num1Copy = new int[m];
        System.arraycopy(nums1, 0, num1Copy, 0, m);
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while (p1 < m && p2 < n) {
            nums1[p++] = num1Copy[p1] < nums2[p2] ? num1Copy[p1++] : nums2[p2++];
        }
        if (p1 < m) {
            System.arraycopy(num1Copy, p1, nums1, p1 + p2, m - p1);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, n - p2);
        }
    }
}
