package 基础入门.class01;

/**
 * Desc:二分查找
 * @author zzs
 * @date 2022/3/21 18:12
 */
public class Code05_BinarySearch {

    // 二分搜索，判断某个数字是否在一个已排序的数组中
    public static boolean exist(int[] sortedArr, int num) {
        int l = 0;
        int r = sortedArr.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (num < sortedArr[mid]) {
                r = mid - 1;
            } else if (num > sortedArr[mid]) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return sortedArr[l] == num;
    }

    // 在一个有序的数组中，找到大于等于某个数字最左的那个位置,没有则返回-1
    public static int nearestIndex(int[] arr, int value) {
        int l = 0;
        int r = arr.length - 1;
        int index = -1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return index;
    }

    // 找到局部最小的位置，没有则返回-1
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 2] > arr[arr.length - 1]) {
            return arr.length - 1;
        }
        int l = 1;
        int r = arr.length - 2;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] > arr[mid - 1]) {
                r = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;
    }
}
