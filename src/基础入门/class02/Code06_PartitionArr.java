package 基础入门.class02;

/**
 * Desc:快排1.0和快排2.0(时间复杂度最坏O(N ^ 2)，最好O(N * logN))
 * 快排大体定义：
 * 给定一个数组arr和一个数num，请把小于等于num的数放在数组的左边，大于num的树放在数组的右边，
 * 返回经过partition后，小于等于num的最后数字的索引。
 * @author zzs
 * @date 2022/3/21 21:26
 */
public class Code06_PartitionArr {

    // 快排1.0，num不从数组中拿出
    public static int partition(int[] arr, int num) {
        int less = -1;
        int cur = 0;
        while (cur < arr.length) {
            if (arr[cur] <= num) {
                swap(arr, ++less, cur++);
            } else {
                cur++;
            }
        }
        return less;
    }

    // 快排2.0，每次都以数组最后一个数作为partition的划分值
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int cur = l;
        int less = l - 1;
        int more = r;
        while (cur < more) {
            if (arr[cur] < arr[r]) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > arr[r]) {
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        swap(arr, more, r);
        return new int[] { less + 1, more };
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
