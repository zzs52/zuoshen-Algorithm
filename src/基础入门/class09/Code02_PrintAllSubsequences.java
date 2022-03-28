package 基础入门.class09;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:打印一个字符串的所有子序列
 * @author zzs
 * @date 2022/3/28 9:16
 */
public class Code02_PrintAllSubsequences {

    public static void printAllSubsequence(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0);
    }

    public static void process(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
            return;
        }
        process(chs, i + 1);
        char tmp = chs[i];
        chs[i] = 0;
        process(chs, i + 1);
        chs[i] = tmp;
    }

    public static void function(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0, new ArrayList<Character>());
    }

    public static void process(char[] chs, int i, List<Character> res) {
        if (i == chs.length) {
            printList(res);
            return;
        }
        List<Character> resKeep = copyList(res);
        resKeep.add(chs[i]);
        process(chs, i + 1, resKeep);
        List<Character> resNoInclude = copyList(res);
        process(chs, i + 1, resNoInclude);
    }

    public static void printList(List<Character> res) {
        return;
    }

    public static List<Character> copyList(List<Character> list) {
        return null;
    }
}
