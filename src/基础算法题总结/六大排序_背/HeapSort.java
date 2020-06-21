package 基础算法题总结.六大排序_背;

/**
 * 堆排序，O(nlogn)，O(1)，不稳定
 * 思想：
 * 1.首先将待排序序列构成一个堆，假设构成一个大根堆，大根堆的性质就是每个节点的值都大于或等于它左右孩子节点的值；
 * 2.然后将堆顶元素与末尾元素交换，交换后末尾元素就是这个序列的最大值
 * 3.然后将剩余 n-1 个元素重新调整为大根堆，再次将堆顶元素与末尾元素交换，交换后末尾元素就是这个序列第二大的值了
 * 4.反复执行，最后就得到了一个递增的有序序列。
 *
 * 排序重建堆的过程是每次将堆顶元素与末尾元素交换，然后重新调整剩余的 n - 1 个元素为大根堆，每次调整的时间为 logn，所以排序重建堆的时间复杂度为 nlogn
 *
 * 建堆时间（初始化堆）：每个节点在进行堆化时，需要比较和交换的节点个数，跟这个节点的高度成正比，也就是第一层节点个数为1，高度为h；第二层节点个数为2，高度为 h-1，以此类推，最后一层节点个数为 2 的 h-1 次方，高度为 1。然后将每个节点的高度求和，得到的就是建堆时间，公式为：S = 2^0 * h + 2^1 *(h-1) + 2^2 *(h-2) +...+ 2^(h-1) * 1 ，将公式左右都乘以 2，然后 2S - S，最后可以得到 S = 2^(h-1) - h - 2 。因为二叉树中的高度 h = logn，代入公式，就可以得到 S = 2n - logn - 2，所以建堆的时间复杂度为 O(n)。
 *
 * 综上所述，整体堆排序的时间复杂度为 O(nlogn)
 */
public class HeapSort {
    public void heapSort(int[] arr) {
        //构建大根堆,从最后一个非叶子节点开始调整,左右孩子节点中较大的交换到父节点中
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            sort(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j >= 1; j--) {
            //将根节点与堆尾节点交换
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;

            //将剩余n-1个元素重新调整为大根堆
            sort(arr, 0, j);
        }
    }

    private void sort(int[] arr, int i, int len) {
        int temp = arr[i];
        int k = 2 * i + 1;
        while (k < len) {
            if (k + 1 < len) {
                k = arr[k] > arr[k + 1] ? k : k + 1;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
                k = 2 * i + 1;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] a = {3, 11, 5, 2, 4, 1, 6, 7, 8, 10, 9};
        HeapSort t = new HeapSort();
        t.heapSort(a);
        for (int i : a) {
            System.out.print(i + ",");
        }
    }
}
