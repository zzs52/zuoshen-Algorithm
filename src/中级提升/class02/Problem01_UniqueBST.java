package 中级提升.class02;

/**
 * Desc:给定一个非负整数n，代表二叉树的节点个数。返回能形成多少种不同的二叉树结构
 * @author zzs
 * @date 2022/4/13 10:04
 */
public class Problem01_UniqueBST {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
