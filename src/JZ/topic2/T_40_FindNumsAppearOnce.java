package JZ.topic2;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 注：num1,num2分别为长度为1的数组。将num1[0],num2[0]设置为返回结果
 * 思路：位运算
 * 任何一个数 异或 自身，等于0；任何一个数 异或 0 等于自身。
 * 先将数组中所有数异或一遍，得到的是两个只出现一次的数的异或结果。
 * 由于这两个数不同，所以它们肯定有一位或几位是不同的(0,1)，所以它们的异或结果中肯定存在1
 * 比如：两数异或结果为 res = 2，也就是0010，将它与helper = 1 异或。
 * 结果为0，所以helper乘以2，也就是0001，变成了0010.如果再乘2，就变成了0100.
 * 然后再与res异或，当结果为0时，表示此时res位上为1。于是就用此时的helper对原数组进行区分。
 * 原数组中出现两次的数所有二进制位置都是相同的。
 * 区分成两个数组后，再对这两个数组各自进行异或，结果分别保存在 num1 和 num2 中。
 */
public class T_40_FindNumsAppearOnce {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int res = 0;
        for (int a : array) {
            res ^= a;
        }
        int helper = 1;
        while ((res & helper) == 0) {
            helper *= 2;
        }
        for (int a : array) {
            if ((a & helper) == 0) {
                num1[0] ^= a;
            } else {
                num2[0] ^= a;
            }
        }
    }
}