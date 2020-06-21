package 基础算法题总结.六大排序_背;

/**
 *   稳定的排序算法：冒泡、插入、归并
 * 不稳定的排序算法：选择、快速、堆排序
 *
 * 冒泡排序，O(n^2)，O(1)，稳定
 * 思想：冒泡排序对相邻的两个元素进行比较，看是否满足大小关系。如果不满足就让它俩互换。每轮冒泡操作都会让至少一个元素移动到它应该在的位置，最多重复 n 次，就完成了 n 个元素的排序工作。
 */
public class BubbleSort {
    public void bubbleSort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true; // 表示有数据交换
                }
            }
            if (!flag) { // 没有数据交换，提前退出
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 2, 4, 1, 6, 7, 8, 10, 9};
        BubbleSort t = new BubbleSort();
        t.bubbleSort(a);
        for (int i : a) {
            System.out.print(i + ",");
        }
    }
}
