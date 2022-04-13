package 中级提升.class02;

/**
 * Desc:
 * 一个完整的括号字符串定义规则如下:
 * ①空字符串是完整的。
 * ②如果s是完整的字符串，那么(s)也是完整的。
 * ③如果s和t是完整的字符串，将它们连接起来形成的st也是完整的。
 * 例如，"(()())"，""和"(())()"是完整的括号字符串，"())("，"()("和")"
 * 是不完整的括号字符串。
 * 牛牛有一个括号字符串s，现在需要在其中任意位置尽量少地添加括号，将其转化
 * 为一个完整的括号字符串。请问牛牛至少需要添加多少个括号。
 * @author zzs
 * @date 2022/4/13 10:14
 */
public class Problem02_NeedParentheses {

    public static int needParentheses(String str){
        if (str == null || str.length() == 0) {
            return 0;
        }
        int count = 0;
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else {
                if (count == 0) {
                    res++;
                } else {
                    count--;
                }
            }
        }
        return count + res;
    }
}
