package 基础入门.class09;

/**
 * Desc:背包问题
 * 给定两个长度都为N的数组weight和values，
 * weight[i]和values[i]分别表示i号物品的重量和价值。
 * 给定一个正数bag，表示一个载重bag的袋子，你装的物品不能超过这个重量，返回你能装下的最多的价值是多少
 * @author zzs
 * @date 2022/3/28 10:13
 */
public class Code07_Knapsack {

    public static int maxValue1(int[] c, int[] p, int bag) {
        return process1(c, p, 0, 0, bag);
    }

    public static int process1(int[] weights, int[] values, int i, int alreadyWeight, int bag) {
        if (alreadyWeight > bag) {
            return 0;
        }
        if (i == weights.length) {
            return 0;
        }
        return Math.max(
                process1(weights, values, i + 1, alreadyWeight, bag),
                values[i] + process1(weights, values, i + 1, alreadyWeight + weights[i], bag));
    }
}
