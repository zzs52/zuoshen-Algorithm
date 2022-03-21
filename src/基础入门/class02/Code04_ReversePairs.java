package 基础入门.class02;

/**
 * Desc:逆序对问题
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 示例：
 * 输入: [7,5,6,4]
 * 输出: 5
 * 解释：
 * {[7,5],[7,6],[7,4],[5,4],[6,4]}
 * @author zzs
 * @date 2022/3/21 21:06
 */
public class Code04_ReversePairs {

    public int reversePairs(int[] nums) {
        return mergeSort(nums);
    }

    private static int mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeSort(nums, l, mid)
                + mergeSort(nums, mid + 1, r)
                +merge(nums, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= r) {
            res += arr[p1] > arr[p2] ? r - p2 + 1 : 0;
            help[i++] = arr[p1] > arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;
    }
}
