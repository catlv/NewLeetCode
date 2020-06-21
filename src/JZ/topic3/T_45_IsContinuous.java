package JZ.topic3;

/**
 * 扑克牌，0来表示两张王，随机抽5张，判断是否凑成顺子。
 * 先统计王的数量，如果后面一个数比前面一个数大于1以上，那么中间的差值就必须用王来补了。
 */

import java.util.Arrays;

public class T_45_IsContinuous {
    public boolean isContinuous(int[] numbers) {
        if (numbers.length != 5) {
            return false;
        }
        int zero = 0;
        int c = 0; //统计i和i+1之间的差值，看需要多少个王来补，比如4和7，7-4-1=2，需要2个王来补
        Arrays.sort(numbers);
        //前面排序后王不可能在5个数的末尾了，又由于下面有i+1，所以这里判断到4即可
        for (int i = 0; i < 4; i++) {
            if (numbers[i] == 0) {
                zero++;
                continue; //只是把王看做0，它并不参与下面的操作，所以直接continue
            }
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            c += numbers[i + 1] - numbers[i] - 1;
        }
        return zero >= c;
    }
}
