package 基础入门.class06;

/**
 * Desc:二叉树中寻找一个节点的后继节点
 * @author zzs
 * @date 2022/3/25 11:39
 */
public class Code06_SuccessorNode {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return null;
        }
        // 1.node有右孩子，他的下一个节点就是右子树的最左边节点
        // 2.node无右孩子，一直往上窜直到是一个节点的左子树是他，这个节点就是他的后继节点
        // 3.node无右孩子，一直往上窜直到他的父为null，那么他的后继节点就是null
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private static Node getLeftMost(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
