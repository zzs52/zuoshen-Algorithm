package 基础入门.class06;

/**
 * Desc:微软面试题，给你可以折的次数，返回最后打开纸条后折痕的顺序
 * @author zzs
 * @date 2022/3/25 11:49
 */
public class Code08_PaperFolding {

    public static void printAllFolds(int n) {
        printProcess(1, n, true);
    }

    // 中序遍历，左子树为凹
    private static void printProcess(int level, int n, boolean down) {
        if (level > n) {
            return;
        }
        printProcess(level + 1, n, true);
        System.out.println(down ? "凹" : "凸");
        printProcess(level + 1, n, false);
    }
}
