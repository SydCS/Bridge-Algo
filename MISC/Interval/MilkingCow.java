import java.util.*;

// https://www.luogu.com.cn/problem/P1204
public class MilkingCow {
    static class Time implements Comparable<Time> {
        int start, end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time t) {
            return this.start - t.start;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Time[] times = new Time[n];
        for (int i = 0; i < n; i++) {
            times[i] = new Time(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(times);

        // 合并区间
        int maxOccupied = times[0].end - times[0].start, maxEmpty = 0;
        int prevStart = times[0].start, prevEnd = times[0].end;
        for (int i = 1; i < n; i++) {
            if (times[i].start > prevEnd) {
                maxEmpty = Math.max(maxEmpty, times[i].start - prevEnd);
                maxOccupied = Math.max(maxOccupied, times[i].end - times[i].start);
                prevStart = times[i].start;
                prevEnd = times[i].end;
            } else {
                maxOccupied = Math.max(maxOccupied, times[i].end - prevStart);
                prevEnd = Math.max(prevEnd, times[i].end);
            }
        }
        System.out.println(maxOccupied + " " + maxEmpty);
        scanner.close();
    }
}
