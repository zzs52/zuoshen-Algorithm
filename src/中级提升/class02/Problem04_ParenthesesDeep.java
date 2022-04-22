package 中级提升.class02;

/**
 * Desc:
 * 一个合法的括号匹配序列有以下定义:
 * ①空串""是一个合法的括号匹配序列
 * ②如果"X"和"Y"都是合法的括号匹配序列，"XY"也是一个合法的括号匹配序列
 * ③如果"X"是一个合法的括号匹配序列，那么"(X)"也是一个合法的括号匹配序列
 * ④每个合法的括号序列都可以由以上规则生成。
 * 例如: "","()","()()","((()))"都是合法的括号序列
 * 对于一个合法的括号序列我们又有以下定义它的深度:
 * ①空串""的深度是0
 * ②如果字符串"X"的深度是x，字符串"Y"的深度是y，那么字符串"XY"的深度为max(x,y)
 * ③如果"X"的深度是x，那么字符串"(X)"的深度是x+1
 * 例如: "()()()"的深度是1，"((()))"的深度是3。牛牛现在给你一个合法的括号
 * 序列，需要你计算出其深度。
 * @author zzs
 * @date 2022/4/13 10:42
 */
public class Problem04_ParenthesesDeep {

    public static boolean isValid(char[] str) {
        if (str == null || str.equals("")) {
            return false;
        }
        int status = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] != ')' && str[i] != '(') {
                return false;
            }
            if (str[i] == ')' && --status < 0) {
                return false;
            }
            if (str[i] == '(') {
                status++;
            }
        }
        return status == 0;
    }

    public static int deep(String s) {
        char[] str = s.toCharArray();
        if (!isValid(str)) {
            return 0;
        }
        int count = 0;
        int max = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                max = Math.max(max, ++count);
            } else {
                count--;
            }
        }
        return max;
    }
}
