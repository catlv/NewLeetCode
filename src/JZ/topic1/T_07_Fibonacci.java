package JZ.topic1;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 */
public class T_07_Fibonacci {
    //1.普通递归
    public int Fibonacci_Recursive(int n) {
        if (n <= 1) {
            return n;
        } else {
            return Fibonacci_Recursive(n - 1) + Fibonacci_Recursive(n - 2);
        }
    }

    //2.改进递归
    //有些 fib[n] 被重复计算了，所以通过将结果存储起来达到优化
    //比如 fib[9]=fib[8]+fib[7]，fib[8]=fib[7]+fib[6]，fib[7]被重复计算了。
    int[] memo = new int[39 + 1];

    public int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        return memo[n] = Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    //非递归
    public int Fibonacci_Non_Recursive(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            b = b + a;
            a = b - a;
        }
        return b;
    }
}