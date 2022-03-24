package 基础入门.class05;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Desc:求二叉树的最大宽度
 * @author zzs
 * @date 2022/3/24 15:48
 */
public class Code04_TreeMaxWidth {

    public static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int getMaxWidth1(Node head) {
        if (head == null) {
            return 0;
        }
        int maxWidth = 0;
        int curWidth = 0;
        int curLevel = 0;
        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node node = null;
        Node left = null;
        Node right = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            left = node.left;
            right = node.right;
            if (left != null) {
                levelMap.put(left, levelMap.get(node) + 1);
                queue.add(left);
            }
            if (right != null) {
                levelMap.put(right, levelMap.get(node) + 1);
                queue.add(right);
            }
            if (levelMap.get(node) > curLevel) {
                curWidth = 1;
                curLevel = levelMap.get(node);
            } else {
                curWidth++;
            }
            maxWidth = Math.max(maxWidth, curWidth);
        }
        return maxWidth;
    }

    /*
    另有一种只用队列不用哈希表的算法：
    Node curEnd 记录当前层的最后一个节点
    Node nextEnd 记录下一层的最后一个节点
    int curLevelNodes 记录当前层的节点数
    int maxWidth 记录最大宽度
     */
    public static int getMaxWidth2(Node head) {
        if (head == null) {
            return 0;
        }
        int maxWidth = 0;
        Node curEnd = head;
        Node nextEnd = null;
        int curLevelNodes = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node node = null;
        Node left = null;
        Node right = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            curLevelNodes++;
            left = node.left;
            right = node.right;
            if (left != null) {
                queue.add(left);
                nextEnd = left;
            }
            if (right != null) {
                queue.add(right);
                nextEnd = right;
            }
            if (node == curEnd) {
                maxWidth = Math.max(maxWidth, curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
                nextEnd = null;
            }
        }
        return maxWidth;
    }
}
