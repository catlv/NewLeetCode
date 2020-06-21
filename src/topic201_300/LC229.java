package topic201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个大小为 n 的数组，找出其中所有出现超过 n/3 次的元素。
 * 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * 投票法：
 * 对于一个数组，出现超过一半的元素最多只有一个；出现超过1/3的元素最多只有两个
 * 所以这题需要设立两个候选人，分三种情况讨论：
 * 1.如果当前元素等于A，则A的票数++;
 * 2.如果当前元素等于B，B的票数++；
 * 3.如果当前元素与A，B都不相等,那么检查此时A或B的票数是否减为0：
 *      如果为0,则当前元素成为新的候选人；
 *      如果A,B两个人的票数都不为0，那么A,B两个候选人的票数均减一；
 *
 * 遍历结束后选出了两个候选人，但是这两个候选人是否满足>n/3，还需要再遍历一遍数组，找出两个候选人的具体票数进行判断。
 */
public class LC229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        int candidateA = nums[0];
        int candidateB = nums[0];
        int countA = 0;
        int countB = 0;
        for (int n : nums) {
            if (candidateA == n) {
                countA++;
            } else if (candidateB == n) {
                countB++;
            } else if (countA == 0) {
                candidateA = n;
                countA = 1;
            } else if (countB == 0) {
                candidateB = n;
                countB = 1;
            } else {
                countA--;
                countB--;
            }
        }
        countA = 0;
        countB = 0;
        for (int n : nums) {
            if (candidateA == n) {
                countA++;
            } else if (candidateB == n) {
                countB++;
            }
        }
        if (countA > nums.length / 3) {
            res.add(candidateA);
        }
        if (countB > nums.length / 3) {
            res.add(candidateB);
        }
        return res;
    }
}
