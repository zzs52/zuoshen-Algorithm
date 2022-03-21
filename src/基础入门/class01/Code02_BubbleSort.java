package 基础入门.class01;

/**
 * Desc:冒泡排序
 * @author zzs
 * @date 2022/3/21 14:08
 */
public class Code02_BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
/*
异或运算：也称为无进位相加。二进制形式下，两个数相同位置数相同则结果为0，数不同则为1。
性质：(1)0 ^ N = N (2)N ^ N = 0 (3)满足交换律和结合律 (4)同一批数异或结果一定一样，与异或顺序无关
注意：异或运算的两个数值可以相同，但指向的内存空间不能相同。
 */
