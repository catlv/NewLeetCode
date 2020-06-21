package topic1_20;

/**
 * 给定n个非负整数a1，a2，...，an，其中每个表示坐标（i，ai）处的点。
 * 绘制n条垂直线，使得线i的两个端点位于（i，ai）和（i，0）。
 * 找到两条线，它们与x轴一起形成一个容器，这样容器就含有最多的水。
 */
public class LC11 {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            res = Math.max(res, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
