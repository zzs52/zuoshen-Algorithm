package 基础入门.class01;

/**
 * Desc:
 * 一组数中有一种出现奇数次的数a，其他数均出现偶数次，找到这个a；
 * 一组数中有两种出现奇数次的数a、b，其他数均出现偶数次，找到a、b。
 * @author zzs
 * @date 2022/3/21 14:10
 */
public class Code03_EvenTimesOddTimes {

    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        System.out.println(eor);
    }

    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        int rightOne = eor & (~eor + 1); // 提取出最右边的1
        int onlyOne = 0;
        for (int cur : arr) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " 另一个数是：" + (onlyOne ^ eor));
    }
}
