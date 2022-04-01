package 基础提升.class04;

/**
 * Desc:树型dp套路
 * 给定一个二叉树，返回其最大路径和。
 * 从二叉树的节点a出发，可以向上或者向下走，但沿途的节点只能经过一次，到达节点b时路径上的节点个数叫作a到b的距离，
 * 那么二叉树任何两个节点之间都有距离，求整棵树上的最大距离。
 * @author zzs
 * @date 2022/4/1 17:00
 */
public class Code01_MaxDistanceInTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int maxDistance(Node head) {
        return process(head).maxDistance;
    }

    public static class Info {
        public int maxDistance;
        public int height;
        public Info(int dis, int h) {
            maxDistance = dis;
            height = h;
        }
    }

    // 返回以x为头的整棵树，两个信息
    public static Info process(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        // info
        int p1 = leftInfo.maxDistance;
        int p2 = rightInfo.maxDistance;
        int p3 = leftInfo.height + 1 + rightInfo.height;
        int maxDistance = Math.max(p3, Math.max(p1, p2));
        int height = Math.max(leftInfo.height, rightInfo.height) + 1 ;
        return new Info(maxDistance, height);
    }
}
