package 中级提升.class02;

/**
 * Desc:
 * 给定一个元素为非负整数的二维数组matrix，每行和每列都是从小到大有序的。
 * 再给定一个非负整数aim，请判断aim是否在matrix中。
 * @author zzs
 * @date 2022/4/13 11:18
 */
public class Problem08_FindNumInSortedMatrix {

    public static boolean isContains(int[][] matrix, int K) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == K) {
                return true;
            } else if (matrix[row][col] < K) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
