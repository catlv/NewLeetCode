package topic1_20;

/**
 * 求两个排序数组的中位数（二分法）。
 * 思路：
 * 整个数组中间的两个数的位置，6,7和8,9，则left为2，right为3，代表第几个数
 * 等价为求第K个小的数，对于偶数个，比如上面例子的1,2,3,4，则需要求第2个小的数和第3个小的数，然后求和除2
 * 对于奇数个，left和right相同，即求两次相同的K
 * getKth表示求两个数组第K个小的数，K在两数组的中间，为left和right
 * 第k个小的数在nums1[i+1:]和nums2中
 * 舍弃掉了nums1的前i个数，即i - start2 + 1个数，于是要找剩下两数组中的第k - (i - start2 + 1)个小的数
 */
public class LC04 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (getKth(nums1, 0, m - 1, nums2, 0, n - 1, left) + getKth(nums1, 0, m - 1, nums2, 0, n - 1, right)) / 2;
    }
    private double getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        //求两数组k/2处的下标
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] < nums2[j]) {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        } else {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
    }
}
