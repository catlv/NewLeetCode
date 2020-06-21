package JZ.topic1;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * 给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 采用二分查找法。
 * 需要考虑三种情况：
 *
 * array[mid] > array[r]:
 * 出现这种情况的array类似[3,4,5,6,0,1,2]，此时最小数字一定在mid的右边。
 * l = mid + 1
 *
 * array[mid] == array[r]
 * 出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边
 * 还是右边,这时只好一个一个试
 * r = r - 1
 *
 * array[mid] < array[r]:
 * 出现这种情况的array类似[4,5,0,1,1,2,3],此时最小数字一定就是array[mid]或者在mid的左
 * 边。因为右边必然都是递增的。
 * r = mid
 *
 * 左乘右除   a << 1  a乘2     a >> 1  a除2
 */
public class T_06_MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        int len = array.length;
        if (len == 0) {
            return 0;
        }
        int l = 0;
        int r = len - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (array[mid] > array[r]) { //mid处以及mid左边的数都不会是最小数，所以l=mid+1，直接排除
                l = mid + 1;
            } else if (array[mid] == array[r]) {
                r = r - 1;
            } else { //此处[mid]<[r]，41123，(mid,r]范围都不会是最小值，但mid及mid左边可能是最小值。
                r = mid;
            }
        }
        return array[l]; //也可以写 array[r]
    }

    public static void main(String[] args) {
        T_06_MinNumberInRotateArray o6 = new T_06_MinNumberInRotateArray();
        int[] array = {1, 0, 1, 1, 1}; // 1,1,1,0,1
        int result = o6.minNumberInRotateArray(array);
        System.out.println(result);
    }
}
