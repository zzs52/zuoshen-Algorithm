package 基础入门.class09;

/**
 * Desc:
 * 规定1和A对应，2和B对应，3和C对应...
 * 那么一个数字字符串比如“111”就可以转化为：“AAA”，“KA”和“AK”
 * 给定一个只有数字字符组成的字符串str,返回有多少种转化结果
 * @author zzs
 * @date 2022/3/28 10:06
 */
public class Code06_ConvertToLetterString {

    private static int process(char[] str, int index) {
        if (index == str.length) {
            return 1;
        }
        if (str[index] == '0') {
            return 0;
        }
        if (str[index] == '1') {
            int res = process(str, index + 1);
            if (index + 1 < str.length) {
                res += process(str, index + 2);
            }
            return res;
        }
        if (str[index] == '2') {
            int res = process(str, index + 1);
            if (index + 1 < str.length && (str[index + 1] >= '0' && str[index + 1] <= '6')) {
                res += process(str, index + 2);
            }
            return res;
        }
        return process(str, index + 1);
    }
}
