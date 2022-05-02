package 基础入门.class06;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Desc:判断是否是完全二叉树
 * @author zzs
 * @date 2022/3/25 10:23
 */
public class Code02_IsCBT {

    public static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<Node>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;

            /**
             * 判断完全二叉树的两个标准：①某个节点有右孩子没有左孩子，则不是完全二叉树
             * ②满足①的条件下，某个节点没有右孩子有左孩子，或者没有左右孩子时，后面遇到的所有节点必须是叶节点。
             */
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }

            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            }
            if (l == null && r == null) {
                leaf = true;
            }
        }
        return true;
    }
}
