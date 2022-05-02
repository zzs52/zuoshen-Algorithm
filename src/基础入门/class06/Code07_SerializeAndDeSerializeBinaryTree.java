package 基础入门.class06;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Desc:二叉树的序列化和反序列化(可以用先序、中序、后序等)
 * @author zzs
 * @date 2022/3/25 11:47
 */
public class Code07_SerializeAndDeSerializeBinaryTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // 序列化
    public static String serialByPre(Node head) {
        // 1.先序遍历，以下划线分割
        if (head == null) {
            return "#_";
        }
        String result = head.value + "_";
        result += serialByPre(head.left);
        result += serialByPre(head.right);
        return result;
    }

    // 反序列化
    public static Node reconByPreString(String preStr) {
        String[] nodeStrings = preStr.split("_");
        Queue<Node> queue = Arrays.stream(nodeStrings)
                .map(str -> "#".equals(str) ? null : new Node(Integer.valueOf(str)))
                .collect(Collectors.toCollection(LinkedList::new));
        return reconPreOrder(queue);
    }

    private static Node reconPreOrder(Queue<Node> queue) {
        Node node = queue.poll();
        if (node != null) {
            node.left = reconPreOrder(queue);
            node.right = reconPreOrder(queue);
        }
        return node;
    }

    public static Node reconByPreString2(String preStr) {
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i != values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder2(queue);
    }

    public static Node reconPreOrder2(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder2(queue);
        head.right = reconPreOrder2(queue);
        return head;
    }
}
