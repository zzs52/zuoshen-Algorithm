package 基础入门.class08;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Desc:贪心算法案例
 * 输入：参数1：正数数组costs，参数2：正数数组profits，参数3：正数k，参数4：正数W
 * costs[i]：表示i号项目的花费
 * profits[i]：表示i号项目在扣除花费之后还能挣到的钱(利润)
 * k：表示你不能并行、只能串行的最多做k个项目
 * W：表示你初始的资金
 * 说明：你每做完一个项目，马上获得的收益，可以支持你去做下一个项目。
 * 输出：你最后获得的最大钱数
 * @author zzs
 * @date 2022/3/27 11:04
 */
public class Code05_IPO {

    public static class Node {

        public int p;
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }

    public static int findMaximizedCapital(int k, int W, int[] profits, int[] costs) {
        Node[] nodes = new Node[profits.length];
        for (int i = 0; i < profits.length; i++) {
            nodes[i] = new Node(profits[i], costs[i]);
        }
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < nodes.length; i++) {
            minCostQ.add(nodes[i]);
        }
        for (int i = 0; i < k; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
                maxProfitQ.add(minCostQ.poll());
            }
            // 做不到 k 项目，即大根堆空了（资金不能做其他项目）也得停
            if (maxProfitQ.isEmpty()) {
                return W;
            }
            W += maxProfitQ.poll().p;
        }
        return W;
    }
}
