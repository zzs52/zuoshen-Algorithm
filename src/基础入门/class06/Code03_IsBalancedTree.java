package 基础入门.class06;

/**
 * Desc:判断是否是平衡二叉树(使用二叉树的套路解法，树型dp题)
 * @author zzs
 * @date 2022/3/25 10:32
 */
public class Code03_IsBalancedTree {

    public static class Node {

        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    // 构建递归过程中的返回值结构
    public class ReturnData {

        public boolean isB; // 是否平衡
        public int h; // 高度

        public ReturnData(boolean B, int h) {
            this.isB = B;
            this.h = h;
        }
    }

    // 主函数
    public boolean isBalance(Node head) {
        return process(head).isB;
    }

    public ReturnData process(Node head) {
        if (head == null) {
            return new ReturnData(true, 0);
        }
        ReturnData leftData = process(head.left); // 得到左子树是否平衡和高度信息
        if (leftData.isB == false) {
            // 当前节点的左子树不平衡，整棵树都不平衡了，高度信息没有用了，直接就-1
            return new ReturnData(false, -1);
        }
        ReturnData rightData = process(head.right);
        if (rightData.isB == false) {
            // 当前节点的右子树不平衡，整棵树都不平衡了，高度信息没有用了，直接就-1
            return new ReturnData(false, -1);
        }
        // 来到这里，说明当前节点的左右子树都平衡，需要对比左右子树的高度差是否大于1
        if(Math.abs(rightData.h - leftData.h) > 1){
            return new ReturnData(false, -1);
        }
        // 左右子树都平衡，且高度差小于等于1，则此节点作为根节点的子树是平衡的
        // 高度则为左右子树中最高的高度+1
        return new ReturnData(true, Math.max(rightData.h, leftData.h) + 1);
    }
}

