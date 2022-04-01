package 基础提升.class04;

import java.util.List;

/**
 * Desc:树型dp套路
 * 派对的最大快乐值
 * 公司的每个员工都符合 Employee 类的描述。整个公司的人员结构可以看作是一棵标准的、没有环的多叉树。
 * 树的头节点是公司唯一的老板。除老板之外的每个员工都有唯一的直接上级。叶节点是没有
 * 任何下属的基层员工(subordinates列表为空)，除基层员工外，每个员工都有一个或多个直接下级。
 * 这个公司现在要办party，你可以决定哪些员工来，哪些员工不来。但是要遵循如下规则。
 * 1.如果某个员工来了，那么这个员工的所有直接下级都不能来
 * 2.派对的整体快乐值是所有到场员工快乐值的累加
 * 3.你的目标是让派对的整体快乐值尽量大
 * 给定一棵多叉树的头节点boss，请返回派对的最大快乐值。
 * @author zzs
 * @date 2022/4/1 17:15
 */
public class Code02_MaxHappy {

    /**
     * 派对的最大快乐值
     * 员工信息的定义如下:
     * class Employee {
     * public int happy; // 这名员工可以带来的快乐值
     * List<Employee> subordinates; // 这名员工有哪些直接下级
     * }
     * 公司的每个员工都符合 Employee 类的描述。 整个公司的人员结构可以看作是一棵标准的、 没有环的
     * 多叉树。 树的头节点是公司唯一的老板。 除老板之外的每个员工都有唯一的直接上级。 叶节点是没有
     * 任何下属的基层员工(subordinates列表为空)， 除基层员工外， 每个员工都有一个或多个直接下级。
     * 这个公司现在要办party， 你可以决定哪些员工来， 哪些员工不来。 但是要遵循如下规则。
     * 1.如果某个员工来了， 那么这个员工的所有直接下级都不能来
     * 2.派对的整体快乐值是所有到场员工快乐值的累加
     * 3.你的目标是让派对的整体快乐值尽量大
     * 给定一棵多叉树的头节点boss， 请返回派对的最大快乐值。
     */
    public static class Employee {
        public int happy; // 这名员工可以带来的快乐值
        List<Employee> nexts; // 这名员工有哪些直接下级
    }

    public static class Info {
        public int laiMaxHappy;
        public int buMaxHappy;
        public Info(int lai, int bu) {
            this.laiMaxHappy = lai;
            this.buMaxHappy = bu;
        }
    }

    public static int maxHappy(Employee boss) {
        Info headInfo = process(boss);
        return Math.max(headInfo.laiMaxHappy, headInfo.buMaxHappy);
    }

    public static Info process(Employee employee) {
        if (employee.nexts.isEmpty()) {
            return new Info(employee.happy, 0);
        }

        int lai = employee.happy;
        int bu = 0;
        for (Employee next : employee.nexts) {
            Info nextInfo = process(next);
            lai += nextInfo.buMaxHappy;
            bu += Math.max(nextInfo.laiMaxHappy, nextInfo.buMaxHappy);
        }
        return new Info(lai, bu);
    }
}
