package 基础提升.class03;

import java.util.LinkedList;

/**
 * Desc:生成窗口最大值数组(滑动窗口算法)
 * @author zzs
 * @date 2022/3/31 10:53
 */
public class Code02_SlidingWindowMaxArray {

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        // LinkedList 就是一个标准的双向链表
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        // 生成的结果数组
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            // 更新双端队列，如果双端队列不为空，并且尾结点(存的是下标)对应数组中的值是否小于等于当前值
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            // 上面一直弹出，直到不符合然后加上当前值。
            qmax.addLast(i);
            // 上面加法是通用的，但是减法是针对该题定制的
            // 当过期的时候（当窗口形成之后再扩充才算过期），窗口形成过程中不会过期
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            // 判断下标过期
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
