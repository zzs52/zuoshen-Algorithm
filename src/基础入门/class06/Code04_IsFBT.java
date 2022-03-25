package 基础入门.class06;

/**
 * Desc:判断是否是满二叉树(使用二叉树的套路解法，树型dp题)
 * @author zzs
 * @date 2022/3/25 11:00
 */
public class Code04_IsFBT {

    public static class Node {

        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static boolean checkFBT(Node head) {
        if (head == null) {
            return true;
        }
        fData c = prosses(head);
        return c.nodes == ((1 << c.height) - 1);
    }

    private  static class fData {

        public int height;
        public int nodes;

        public fData(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    public static fData prosses(Node head) {
        if (head == null) {
            return new fData(0,0);
        }
        fData leftData = prosses(head.left);
        fData rightData = prosses(head.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;
        return new fData(height, nodes);
    }
}
