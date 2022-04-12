package 中级提升.class01;

/**
 * Desc:滑动窗口技巧
 * @author zzs
 * @date 2022/4/12 10:49
 */
public class Problem01_CordCoverMaxPoint {

    // 长度为L的绳子最多覆盖几个点，请保证arr有序
    public static int maxPoint(int[] arr, int L) {
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int nearest = nearestIndex(arr, i, arr[i] - L);
            res = Math.max(res, i - nearest + 1);
        }
        return res;
    }

    // 在arr[0..R]范围上，找满足>=value的最左位置
    public static int nearestIndex(int[] arr, int R, int value) {
        int L = 0;
        int index = R;
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }
}
