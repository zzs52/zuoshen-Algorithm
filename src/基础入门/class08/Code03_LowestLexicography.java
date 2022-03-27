package 基础入门.class08;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Desc:贪心算法案例
 * 给定一个字符串类型的数组strs，请找到一种拼接顺序，
 * 使得将所有的字符串拼接起来组成的大字符串是所有可能性中字典顺序最小的，并返回这个大字符串。
 * @author zzs
 * @date 2022/3/27 10:46
 */
public class Code03_LowestLexicography {

    public static class MyComparator implements Comparator<String> {
        // 自定义比较器
        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 使用自己的比较器
        Arrays.sort(strs, new MyComparator());
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }
}
