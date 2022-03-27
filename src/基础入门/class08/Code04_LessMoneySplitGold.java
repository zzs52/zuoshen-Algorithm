package 基础入门.class08;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Desc:贪心算法案例(哈夫曼编码问题)
 * 一块金条切成两半，是需要花费和长度数值一样的铜板的。
 * 比如长度为20的金条，不管切成长度多大的两半，都要花费20个铜板。一群人想整分整块金条，怎么分最省铜板？
 * 这其实是一个哈夫曼树。
 * @author zzs
 * @date 2022/3/27 10:53
 */
public class Code04_LessMoneySplitGold {

    public static int lessMoney(int[] arr) {
        // Java 中小根堆可以采用优先级队列实现，如果实现大根堆重写比较器即可
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // 将数组中元素全部塞入优先级队列
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (priorityQueue.size() > 1) {
            cur = priorityQueue.poll() + priorityQueue.poll();
            sum += cur;
            priorityQueue.add(cur);
        }
        return sum;
    }

    public static class MinheapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static class MaxheapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}
