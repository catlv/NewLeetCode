package JZ.topic3;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、if、while、else等关键字语句。
 * 思路：原本是 if(n>0) 然后进行递归，这里可以换成使用 (n > 0) && (递归) 来达成。
 */
public class T_47_Sum {
    public int Sum_Solution(int n) {
        int sum = n;
        if (n > 0) {
            sum += Sum_Solution(n - 1);
        }
        return sum;
    }
}
