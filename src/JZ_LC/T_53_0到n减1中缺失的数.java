package JZ_LC;

public class T_53_0到n减1中缺失的数 {
    public int missingNumber(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        //当nums[]里面只有一个0时，需要返回的是1，以这个边界条件来判断要不要加等于号
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m == nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
