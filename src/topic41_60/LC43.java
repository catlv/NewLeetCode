package topic41_60;

/**
 * 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
 * 均不以零开头，除非是数字 0 本身。
 *
 * 思路：
 * 对于0-9之间的数，比如3x7=21，3中下标为i的数乘以7中下标为j的数后，结果的个位的数在21的下标为i+j+1处，
 * 结果的十位的数在21的下标为i+j处；
 * 由于长度为2的99，乘以长度为3的999，结果为长度为5的98901，所以要构造长度为2+3=5的数组来存放。
 *
 * 步骤：
 * 1.构造长度为num1与num2长度之和的数组digits
 * 2.两个for循环从他们的最后一位开始
 * 3.通过num.charAt(i)-'0'来将他们的最后一位的数转换为int型的整数
 * 4.sum1字符串第i位置的数与sum2字符串第j位置的数相乘(它们都是从最后一位开始的)，得到mul
 * 5.相乘结果的个位数落在i+j+1处，十位数落在i+j处
 * 6.由于在此之前也进行过乘法(因为从最后一位开始乘过来的)，所以个位数所落在的地方原本可能存在之前进过来的数，需要加上，得到sum。
 * 7.此时sum的个位数就是i+j+1处的新数，sum的十位数加进i+j处的数中。
 */
public class LC43 {
    public String multiply(String num1, String num2) {
        int[] digits = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + digits[p2];
                digits[p2] = sum % 10;
                digits[p1] += sum / 10;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int digit : digits) {
            //消除开头的0，比如063
            if (res.length() == 0 && digit == 0) {
                continue;
            }
            res.append(digit);
        }
        //避免消除0的情况
        return res.length() == 0 ? "0" : res.toString();
    }
}
