package JZ_LC;

//递归
public class T_64_求1加2加3加到n {
    public int sumNums(int n) {
        int sum = n;
        if (n > 0) {
            sum += sumNums(n - 1);
        }
        return sum;
    }
}
