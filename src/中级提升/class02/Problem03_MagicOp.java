package 中级提升.class02;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Desc:
 * 给一个包含n个整数元素的集合a，一个包含m个整数元素的集合b。
 * 定义magic操作为，从一个集合中取出一个元素，放到另一个集合里，且操作过
 * 后每个集合的平均值都大于操作前。
 * 注意以下两点：
 * 1）不可以把一个集合的元素取空，这样就没有平均值了
 * 2）值为x的元素从集合b取出放入集合a，但集合a中已经有值为x的元素，则a的
 * 平均值不变（因为集合元素不会重复），b的平均值可能会改变（因为x被取出了）
 * 问最多可以进行多少次magic操作？
 * @author zzs
 * @date 2022/4/13 10:32
 */
public class Problem03_MagicOp {

    public static int maxOps(int[] arr1, int[] arr2) {
        double sum1 = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum1 += (double) arr1[i];
        }
        double sum2 = 0;
        for (int i = 0; i < arr2.length; i++) {
            sum2 += (double) arr2[i];
        }
        // 如果两个集合的平均值相等不用操作
        if (avg(sum1, arr1.length) == avg(sum2, arr2.length)) {
            return 0;
        }
        int[] arrMore = null;
        double moreSum = 0;
        int[] arrLess = null;
        double lessSum = 0;
        if (avg(sum1, arr1.length) > avg(sum2, arr2.length)) {
            arrMore = arr1;
            moreSum = sum1;
            arrLess = arr2;
            lessSum = sum2;
        }else{
            arrMore = arr2;
            moreSum = sum2;
            arrLess = arr1;
            lessSum = sum1;
        }
        Arrays.sort(arrMore);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arrLess.length; i++) {
            set.add(arrLess[i]);
        }
        int moreSize = arrMore.length;
        int lessSize = arrLess.length;
        int ops = 0;
        for (int i = 0; i < arrMore.length; i++) {
            double cur = (double) arrMore[i];
            if (cur < avg(moreSum, moreSize) && cur > avg(lessSum, lessSize) && !set.contains(arrMore[i])) {
                moreSum -= cur;
                moreSize--;
                lessSum += cur;
                lessSize++;
                set.add(arrMore[i]);
                ops++;
            }
        }
        return ops;
    }

    public static double avg(double sum, int len) {
        return sum / (double) len;
    }
}
