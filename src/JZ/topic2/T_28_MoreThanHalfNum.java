package JZ.topic2;

import java.util.Arrays;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * 票数法：时间复杂度 O(n)，空间复杂度 O(1)
 * 设众数为 res，设票数为 votes，当票数 votes 为0时，将数组中此时位置的数设为众数，接下来的数组中的数，如果等于众数，票数就加1，不等于众数则减一。当票数变为0时，就重新设置当前位置的数为众数，如此反复。最后的众数即为结果。
 *
 * 解答网址：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
 */
public class T_28_MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int[] array) {
        //方案一：投票法
        int res = 0;
        int votes = 0;
        for (int a : array) {
            if (votes == 0) {
                res = a;
            }
            votes += a == res ? 1 : -1;
        }

        //方案二
//        Arrays.sort(array);
//        int res = array[(array.length - 1) / 2];


        //前面只是求出了众数，但根据题目要求还要判断是否众数出现的次数超过数组长度的一半
        int count = 0;
        for (int a : array) {
            if (a == res) {
                count++;
            }
        }
        if (count * 2 > array.length) {
            return res;
        }
        return 0;
    }
}
