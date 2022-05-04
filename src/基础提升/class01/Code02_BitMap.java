package 基础提升.class01;

/**
 * Desc:位图
 * @author zzs
 * @date 2022/3/29 11:44
 */
public class Code02_BitMap {

    public static void main(String[] args)
    {
        int[] arr = new int[10]; // 4byte*8bit*10->320bits
        // arr[0] 0-31
        int i = 178; // 想取得178个bit的状态
        int numIndex = 178 / 32;
        int bitindex = 178 % 32;
        // 拿到178位的状态
        int s = ((arr[numIndex] >> bitindex) & 1);
        // 请把178位的状态改为1
        arr[numIndex] = arr[numIndex] | (1 << (bitindex));
        // 请把178位的状态改为0
        arr[numIndex] = arr[numIndex] &( ~ (1 << bitindex));
    }
}
