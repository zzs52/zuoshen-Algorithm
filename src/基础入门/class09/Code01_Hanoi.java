package 基础入门.class09;

/**
 * Desc:暴力递归(汉诺塔问题)
 * @author zzs
 * @date 2022/3/28 9:08
 */
public class Code01_Hanoi {

    public static void hanoi(int n) {
        if (n > 0) {
            func(n, n, "left", "mid", "right");
        }
    }

    public static void func(int rest, int down, String from, String help, String to) {
        if (rest == 1) {
            System.out.println("move " + down + " from " + from + " to " + to);
        } else {
            func(rest - 1, down - 1, from, to, help);
            func(1, down, from, help, to);
            func(rest - 1, down - 1, help, from, to);
        }
    }
}
