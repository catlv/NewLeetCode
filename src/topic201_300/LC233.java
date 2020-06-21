package topic201_300;

/**
 * LeetCode 233题，剑指offer 31题
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 *
 * 思路：
 * 一. 5246，先是个位6，个位的变化范围是0~9，而这样的变化，会有524次，所以这里有524个1，又因为最后一次有个6，所以还要加一次，所以个位的1的个数是524+1 = 525；
 * 二. 再看十位，十位上的数字是4，所以同理，这个位数的上的1的个数应该是52 * 10，注意这里不是52 * 1，因为，10位上的数后面10-20之间有10个1，且最后4>1，所以还要加上10，所以十位上的1的个数是52 * 10+10 = 530。这里要注意如果十位上的数字是1的话，就要看个位上的数是多少了，也就是10 ~ 20之间取多少个，这时候我们只要计算n%10+1就行了。
 * 三. 然后同理推高位，可以得到1~5246中1的个数是(524 * 1+1)+(52 * 10+10)+(5 * 100+100) +( 0 * 1000+1000) = 2655个。
 */
public class LC233 {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        int res = 0;
        // base表示当前判断的位数、cur表示当前位、height表示高位
        int base = 1;
        int cur;
        int height = n;
        while (height > 0) {
            cur = height % 10;
            height /= 10;
            res += height * base; //先加上一开始的
            if (cur == 1) { //如果是计算2的出现次数，此处就改为2
                res += (n % base) + 1; //==1 就要看前面的了
            } else if (cur > 1) { //如果是计算2的出现次数，此处就改为2
                res += base; //后面剩的，>1 还要+base
            }
            base *= 10;
        }
        return res;
    }
}
