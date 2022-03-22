package 基础入门.class03;

import java.util.PriorityQueue;

/**
 * Desc:已知一个几乎有序的数组，几乎有序是指如果把数组排好序的话，每个元素移动的距离可以不超过k。
 * 请选择一个排序算法针对这个数据进行排序。(时间复杂度O(N * logK))
 * @author zzs
 * @date 2022/3/22 12:28
 */
public class Code02_SortArrayDistanceLessThanK {

    public static void sortArrayDistanceLessThanK(int[] arr, int k) {
        // 使用优先级队列，默认为小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index <= Math.min(arr.length, k); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; index++) {
            arr[i++] = heap.poll();
            heap.add(arr[index]);
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }
}
