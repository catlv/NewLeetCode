package topicPlus;

/**
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 *
 * 思路：反转k个，跳过k个，最后剩余的不够k个，全部反转
 */
public class LC541 {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int i = 0;
        while (i < arr.length) {
            if (i + 2 * k <= arr.length) {
                //反转i ~ i+k
                reverseArr(arr, i, i + k - 1);
            } else if (i + k <= arr.length) {
                //反转 i ~ i+k
                reverseArr(arr, i, i + k - 1);
            } else { // if(i + k > arr.length)
                //反转 i ~ arr.length - 1
                reverseArr(arr, i, arr.length - 1);
            }
            i += 2 * k;
        }
        return String.valueOf(arr);
    }

    private void reverseArr(char[] arr, int from, int end) {
        for (int i = from, j = end; i < j; i++, j--) {
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }
}
