package JZ.topic1;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 解答：如果第一次只跳了1级，剩下n-1级，也就是有f(n-1)种跳法
 * 如果第一次跳了2级，剩下n-2级，有f(n-2)种跳法
 * ...
 * 如果第一次跳了n-1级，只剩下1级了，只有1中跳法
 * 加起来就是 f(n) = f(n-1) + f(n-2) + ... + f(1)
 * f(n-1) = f(n-2) + ... + f(1)
 * 所以 f(n) = 2f(n-1)
 */
public class T_09_JumpFloor2 {
    public int JumpFloor2(int target) {
        if (target <= 1) {
            return target;
        }
        int sum = 1;
        for (int i = 2; i <= target; i++) {
            sum *= 2;
        }
        return sum;

//        递归法，复杂度高
//        if (target <= 1) {
//            return target;
//        } else {
//            return JumpFloor2(target - 1) * 2;
//        }
    }
}
