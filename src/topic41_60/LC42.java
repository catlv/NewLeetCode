package topic41_60;

/**
 * 在一个位置能容下的雨水量等于 Math.min(它左边柱子的最大高度,它右边柱子的最大高度) - 它的高度.
 */
public class LC42 {
    //dp法
    //lm表示的是第i列左边的最高高度，不包括它自身
    public int trap(int[] height) {
        int res = 0;
        int[] lm = new int[height.length];
        int[] rm = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            lm[i] = Math.max(lm[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i > 0; i--) {
            rm[i] = Math.max(rm[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(lm[i], rm[i]);
            if (min > height[i]) {
                res += min - height[i];
            }
        }
        return res;
    }

    //dp空间优化
    public int trap2(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (l < r) {
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);
            if (leftMax <= rightMax) {
                res += leftMax - height[l++];
            } else {
                res += rightMax - height[r--];
            }
        }
        return res;
    }
}
