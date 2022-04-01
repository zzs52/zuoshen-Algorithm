package 基础提升.class05;

public class Code02_Power {

    // 判断一个无符号数是2的幂
    public static boolean is2Power(int n) {
        return (n & (n - 1)) == 0;
    }

    // 判断一个无符号数是4的幂
    public static boolean is4Power(int n) {
        // 在 1，3，5，7 位才是1            // 0x5555555 = 01....1010101
        return (n & (n - 1)) != 0 && (n & 0x55555555) != 0;
    }
}
