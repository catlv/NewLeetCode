package topic201_300;

class Solution {
    /**
     * Hash思想
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        int[] arr = new int[max - min + 1];
        for (int n : nums) arr[max - n]++;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum >= k) {
                return max - i;
            }
        }
        return 0;
    }
}
