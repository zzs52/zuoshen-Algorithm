package 基础入门.class02;

/**
 * Desc:用递归方法找一个数组中的最大值
 * @author zzs
 * @date 2022/3/21 19:21
 */
public class Code01_GetMax {

    public static int getMax(int[] arr) {
        return getMax(arr, 0, arr.length - 1);
    }

    private static int getMax(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = l + ((r - l) >> 1);
        int leftMax = getMax(arr, l, mid);
        int rightMax = getMax(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }
}
