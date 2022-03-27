package 基础入门.class08;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Desc:贪心算法案例
 * 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。
 * 给你每一个项目开始的时间和结束的时间(给你一个数组，里面是一个个具体的项目)，
 * 你来安排宣讲的日程，要求会议室进行的宣讲的场次最多。返回这个最多的宣讲场次。
 * @author zzs
 * @date 2022/3/27 10:29
 */
public class Code02_BestArrange {

    public static class Program {

        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(Program[] programs, int currentTime) {
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            // 如果当前时间小于项目的开始时间，则项目可以安排
            if (currentTime <= programs[i].start) {
                // 项目可以做，即项目数 + 1;
                result++;
                // 当前时间来到项目的结束时间，表示项目做完了
                currentTime = programs[i].end;
            }
        }
        return result;
    }
}
