package JZ.topic1;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 前偶 后奇 ，就交换。类似冒泡排序
 */
public class T_13_ReOrderArray {
    public void reOrderArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) { //前偶 后奇 ，就交换
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        T_13_ReOrderArray o13 = new T_13_ReOrderArray();
        int[] array = {1, 3, 2, 4, 6, 7, 9};
        o13.reOrderArray(array);
        System.out.println(Arrays.toString(array)); //打印数组
    }
}
