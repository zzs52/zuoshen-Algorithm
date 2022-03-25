package 基础入门.class06;

import java.util.Stack;

/**
 * Desc:判断是否是二叉搜索树
 * @author zzs
 * @date 2022/3/25 10:15
 */
public class Code01_IsBST {

    public static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // 递归版本
    private static int pre = Integer.MIN_VALUE;

    public static Boolean isBST1(Node head) {
        boolean res = true;
        if (head == null) {
            return res;
        }
        isBST1(head.left);
        if (head.value > pre) {
            pre = head.value;
        } else {
            res = false;
        }
        isBST1(head.right);
        return res;
    }

    //非递归
    public static Boolean isBST2(Node head) {
        int pre = Integer.MIN_VALUE;
        boolean res = true;
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    if (head.value > pre) {
                        pre = head.value;
                    } else {
                        res = false;
                    }
                    head = head.right;
                }
            }
        }
        return res;
    }

    // 树型dp套路
    public static class Info {

        private boolean isBST;
        private int min;
        private int max;

        public Info(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    public static boolean isBST3(Node head) {
        if (head == null) {
            return true;
        }
        return process(head).isBST;
    }

    private static Info process(Node head) {
        if (head == null) {
            return null;
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        int min = head.value;
        int max = head.value;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }
        boolean isBST = false;
        if (
                (leftInfo == null ? true : (leftInfo.isBST && head.value > leftInfo.max))
                &&
                (rightInfo == null ? true : (rightInfo.isBST && head.value < rightInfo.min))
        ) {
            isBST = true;
        }
        return new Info(isBST, min, max);
    }
}
