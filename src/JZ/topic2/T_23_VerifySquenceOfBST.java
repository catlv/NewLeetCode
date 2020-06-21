package JZ.topic2;

/**
 * 判断数组是不是某二叉搜索树(BST)的后序遍历的结果
 */
public class T_23_VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return isBST(sequence, 0, sequence.length - 1);
    }

    private boolean isBST(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int i = start;
        while (i < end && sequence[i] < sequence[end]) {
            i++;
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }
        return isBST(sequence, start, i - 1) && isBST(sequence, i, end - 1);
    }
}
