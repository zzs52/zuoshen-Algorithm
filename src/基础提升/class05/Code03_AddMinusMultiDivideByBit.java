package 基础提升.class05;

/**
 * Desc:使用位运算进行无符号数的加减乘除
 * @author zzs
 * @date 2022/4/2 11:47
 */
public class Code03_AddMinusMultiDivideByBit {

    // 加法运算
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    // 一个数相反数
    public static int negNum(int n) {
        return add(~n, 1);
    }

    // 减法运算
    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    // 乘法运算
    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public static boolean isNeg(int n) {
        return n < 0;
    }

    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 31; i > -1; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }
}
