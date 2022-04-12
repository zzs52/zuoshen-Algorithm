package 中级提升.class01;

/**
 * Desc:概率转化(拒绝采样)问题
 * 给定一个函数f，可以1～5的数字等概率返回一个。请加工出1～7的数字等概率返回一个的函数g。
 *
 * 给定一个函数f，可以a～b的数字等概率返回一个。请加工出c～d的数字等概率返回一个的函数g。
 *
 * 给定一个函数f，以p概率返回0，以1-p概率返回1。请加工出等概率返回0和1的函数g
 * @author zzs
 * @date 2022/4/12 11:01
 */
public class Problem06_Rand5ToRand7 {

    // 条件：给一个等概率返回1到5的基础函数
    public static int f() {
        return (int) (Math.random() * 5) + 1;
    }

    // 利用基础函数，设计一个只返回0和1的函数
    public static int rand0To1() {
        int res = 0;
        do {
            res = f();
        } while (res == 3);
        // basic: 1  2  3  4  5
        // 目标: 0  0  循环  1  1
        return res < 3 ? 0 : 1;
    }

    // 利用基础函数+rand0To1，请设计一个等概率返回1到7的函数
    public static int g() {
        int res = 0;
        do {
            // 7需要3个二进制位，从最高位开始计算返回
            res = rand0To1() << 2 + rand0To1() << 1 + rand0To1();
        } while (res == 7);
        // 以上do-while，等概率返回0到6，然后再加1返回
        return res + 1;
    }

    // 基础函数：以p概率返回0，以1-p概率返回1
    public static int basicP() {
        double p = 0.83;
        return Math.random() < p ? 0 : 1;
    }

    // 利用basicP，设计一个只返回0和1的函数
    public static int rand01() {
        int num;
        do {
            num = basicP();
        } while (num == basicP());
        // 两次计算，当出现01和10就返回
        return num;
    }

    // 设计一个0到3的函数
    public static int rand0To3() {
        return rand01() * 2 + rand01();
    }

    // 设计一个1到6的函数
    public static int rand1To6() {
        int num = 0;
        do {
            num = rand0To3() * 4 + rand0To3();
        } while (num > 11);
        return num % 6 + 1;
    }

    public static int rand1ToM(int m) {
        return (int) (Math.random() * m) + 1;
    }

    public static int rand1ToN(int n, int m) {
        int[] nMSys = getMSysNum(n - 1, m);
        int[] randNum = getRanMSysNumLessN(nMSys, m);
        return getNumFromMSysNum(randNum, m) + 1;
    }

    public static int[] getMSysNum(int value, int m) {
        int[] res = new int[32];
        int index = res.length - 1;
        while (value != 0) {
            res[index--] = value % m;
            value = value / m;
        }
        return res;
    }

    public static int[] getRanMSysNumLessN(int[] nMSys, int m) {
        int[] res = new int[nMSys.length];
        int start = 0;
        while (nMSys[start] == 0) {
            start++;
        }
        int index = start;
        boolean lastEqual = true;
        while (index != nMSys.length) {
            res[index] = rand1ToM(m) - 1;
            if (lastEqual) {
                if (res[index] > nMSys[index]) {
                    index = start;
                    lastEqual = true;
                    continue;
                } else {
                    lastEqual = res[index] == nMSys[index];
                }
            }
            index++;
        }
        return res;
    }

    public static int getNumFromMSysNum(int[] mSysNum, int m) {
        int res = 0;
        for (int i = 0; i != mSysNum.length; i++) {
            res = res * m + mSysNum[i];
        }
        return res;
    }

    public static void printCountArray(int[] countArr) {
        for (int i = 0; i != countArr.length; i++) {
            System.out.println(i + " appears " + countArr[i] + " times");
        }
    }

    public static void main(String[] args) {
        int testTimes = 1000000;
        int[] countArr1 = new int[8];
        for (int i = 0; i != testTimes; i++) {
            countArr1[g()]++;
        }
        printCountArray(countArr1);

        System.out.println("=====================");

        int[] countArr2 = new int[7];
        for (int i = 0; i != testTimes; i++) {
            countArr2[rand1To6()]++;
        }
        printCountArray(countArr2);

        System.out.println("=====================");

        int n = 17;
        int m = 3;
        int[] countArr3 = new int[n + 1];
        for (int i = 0; i != 2000000; i++) {
            countArr3[rand1ToN(n, m)]++;
        }
        printCountArray(countArr3);

        System.out.println("=====================");
    }
}
