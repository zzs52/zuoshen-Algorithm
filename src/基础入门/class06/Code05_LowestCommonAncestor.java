package 基础入门.class06;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Desc:二叉树中寻找两个节点的最低公共祖先
 * @author zzs
 * @date 2022/3/25 11:22
 */
public class Code05_LowestCommonAncestor {

    public static class Node {

        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node lca1(Node head, Node o1, Node o2) {
        HashMap<Node, Node> root = new HashMap<>();
        root.put(head, head);
        storeRoot(head, root);
        HashSet<Node> set = new HashSet<>();
        Node cur = o1;
        while (cur != head) {
            set.add(cur);
            cur = root.get(cur);
        }
        cur = o2;
        while (cur != head) {
            if (set.contains(cur)) {
                return cur;
            }
            cur = root.get(cur);
        }
        return head;
    }

    public static void storeRoot(Node head, HashMap<Node, Node> root) {
        if (head == null) {
            return;
        }
        root.put(head.left, head);
        root.put(head.right, head);
        storeRoot(head.left, root);
        storeRoot(head.right, root);
    }

    /**
     * 解法2 优化递归思路：
     * o1与o2的所有结构关系：
     * 1）o1是o2的lca 或 o2是o1的lca
     * 2）o1与o2不互为lca 即它们的lca是其他节点
     * **/
    public Node lca2(Node root, Node o1, Node o2) {
        if (root == null || root == o1 || root == o2) {
            return root;
        }
        Node leftData = lca2(root.left, o1, o2);
        Node rightData = lca2(root.right,o1,o2);
        if (leftData != null && rightData != null) {
            return root;
        }
        return leftData != null ? leftData : rightData;
    }
}
