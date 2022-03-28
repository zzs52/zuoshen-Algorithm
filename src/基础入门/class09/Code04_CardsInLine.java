package 基础入门.class09;

/**
 * Desc:两人分别先手和后手拿牌，看谁最后获得的分数最大
 * @author zzs
 * @date 2022/3/28 9:47
 */
public class Code04_CardsInLine {

    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(first(arr, 0, arr.length - 1), second(arr, 0, arr.length - 1));
    }

    public static int first(int[] arr, int beginIndex, int endIndex) {
        if (beginIndex == endIndex) {
            return arr[beginIndex];
        }
        return Math.max(arr[beginIndex] + second(arr, beginIndex + 1, endIndex),
                arr[endIndex] + second(arr, beginIndex, endIndex - 1));
    }

    public static int second(int[] arr, int beginIndex, int endIndex) {
        if (beginIndex == endIndex) {
            return 0;
        }
        return Math.min(first(arr, beginIndex + 1, endIndex), first(arr, beginIndex, endIndex - 1));
    }
}
