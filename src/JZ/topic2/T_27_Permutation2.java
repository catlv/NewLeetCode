package JZ.topic2;

import java.util.ArrayList;
import java.util.Collections;

public class T_27_Permutation2 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();

        if (str.length() == 0) {
            return res;
        }
        helper(str.toCharArray(), 0, res);
        Collections.sort(res); //需要按字典序打印，所以此时要sort
        return res;
    }

    private void helper(char[] chars, int i, ArrayList<String> res) {
        if (i == chars.length - 1) {
            res.add(String.valueOf(chars));
        } else {
            for (int j = i; j < chars.length; j++) {
                if (j != i && chars[i] == chars[j]) {
                    continue;
                }
                swap(chars, i, j);
                helper(chars, i + 1, res);
                swap(chars, i, j);
            }
        }
    }

    private void swap(char[] chars, int m, int n) {
        char temp;
        temp = chars[m];
        chars[m] = chars[n];
        chars[n] = temp;
    }

    public static void main(String[] args) {
        T_27_Permutation2 t = new T_27_Permutation2();
        String str = "abc";
        ArrayList<String> res = t.Permutation(str);
        System.out.println(res);
    }
}
