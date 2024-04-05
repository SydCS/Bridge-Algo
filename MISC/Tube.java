import java.util.Arrays;
import java.util.Scanner;

// https://www.acwing.com/problem/content/description/5410/
public class Tube {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), len = scanner.nextInt();
        int[] L = new int[n], S = new int[n];
        int maxS = 0;
        for (int i = 0; i < n; i++) {
            L[i] = scanner.nextInt();
            S[i] = scanner.nextInt();
            maxS = Math.max(maxS, S[i]);
        }

        // 二分 最早时间
        int l = 1, r = maxS + len;
        while (l < r) {
            int mid = (int) (((long) l + r) >> 1); // 2e9 + 2e9 可能爆 int
            if (check(mid, L, S, n, len)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(r);
        scanner.close();
    }

    static class Range implements Comparable<Range> {
        int start, end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Range t) {
            return this.start - t.start;
        }
    }

    private static boolean check(int T, int[] L, int[] S, int n, int len) {
        // 合并区间
        Range[] range = new Range[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (S[i] <= T) {
                range[count++] = new Range(Math.max(1, L[i] - (T - S[i])),
                        (int) Math.min((long) len, (long) L[i] + (T - S[i])));
            }
        }
        Arrays.sort(range, 0, count);

        if (range[0].start > 1)
            return false;

        int prevEnd = range[0].end;
        for (int i = 1; i < count; i++) {
            if (range[i].start > prevEnd + 1) {
                return false;
            } else {
                prevEnd = Math.max(prevEnd, range[i].end);
            }
        }
        return prevEnd == len;
    }
}