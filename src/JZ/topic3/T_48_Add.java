package JZ.topic3;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 思路：
 * 先求出两数的异或，和两数的 (按位与)<<1 ，然后产生新的两个数，再循环以上步骤
 * 最后异或的结果即为两数之后，此时两数的 (按位与)<<1 的值为0。
 */
public class T_48_Add {
    public int Add(int num1, int num2) {
        int sum = num1;
        while (num2 != 0) {
            sum = num1 ^ num2;
            int b = (num1 & num2) << 1;
            num1 = sum;
            num2 = b;
        }
        return sum;
    }
}
