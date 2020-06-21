package topic41_60;
/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * 思路：maxIndex ——— 表示从当前位置所能跳到的最远位置的下标
 *      num[i] ——— 表示i位置所能跳的最远距离
 *      nums[i] + i ——— 表示i位置左边的距离加上i位置往右能跳的最远距离，即i位置跳完最远距离后所处位置的下标
 *      num[i] + i 可能会小于maxIndex ，所以需要Math.max，比如 100，1，0，0
 *      if (maxIndex < i) 表示前面i-1部分所能跳到的最远位置的下标小于i，意思是没能跳到i位置，此时就无法继续往后跳了
 */
public class LC55 {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxIndex < i) {
                return false;
            }
            maxIndex = Math.max(nums[i] + i, maxIndex);
        }
        return true;
    }
}