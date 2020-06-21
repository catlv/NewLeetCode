package topicPlus;

import java.util.Stack;

/**
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 */
public class LC1190 {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(i);
            }
            if (arr[i] == ')') {
                reverse(arr, stack.pop() + 1, i - 1);
            }
        }
        for (char c : arr) {
            if (c != ')' && c != '(') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private void reverse(char[] arr, int l, int r) {
        while (r > l) {
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            r--;
            l++;
        }
    }
}
