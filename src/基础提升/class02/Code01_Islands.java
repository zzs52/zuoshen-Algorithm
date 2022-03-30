package 基础提升.class02;

/**
 * Desc:岛问题
 * 一个矩阵中只有 0 和 1 两种值，每个位置都可以和自己的上、下、左、右四个位置相连接，
 * 如果有一片 1 连接在一起，则这个部分称为一个岛，求一个矩阵中有多少个岛。
 * 以下代码是在单cpu单核的情况下
 * @author zzs
 * @date 2022/3/30 11:26
 */
public class Code01_Islands {

    public static int countIslands(int[][] inputArray) {
        if (inputArray == null || inputArray[0] == null) {
            return 0;
        }
        int row = inputArray.length;
        int column = inputArray[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (inputArray[i][j] == 1) {
                    res++;
                    infect(inputArray, i, j, row, column);
                }
            }
        }
        return res;
    }

    public static void infect(int[][] inputArray, int i, int j, int row, int column) {
        if (i < 0 || i >= row || j < 0 || j >= column || inputArray[i][j] != 1) {
            return;
        }
        inputArray[i][j] = 2;
        infect(inputArray, i + 1, j, row, column);
        infect(inputArray, i - 1, j, row, column);
        infect(inputArray, i, j + 1, row, column);
        infect(inputArray, i, j - 1, row, column);
    }
}
