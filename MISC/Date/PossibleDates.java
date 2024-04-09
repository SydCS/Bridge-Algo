import java.util.*;

// https://www.luogu.com.cn/problem/P8651
public class PossibleDates {
    static int[] months = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    static int isLeapYear(int y) {
        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0)
            return 1;
        else
            return 0;
    }

    static int getDays(int y, int m) {
        if (m == 2)
            return 28 + isLeapYear(y);
        else
            return months[m];
    }

    static class Date implements Comparable<Date> {
        int y, m, d;

        public Date(int y, int m, int d) {
            this.y = y;
            this.m = m;
            this.d = d;
        }

        @Override
        public int compareTo(Date o) {
            return this.y - o.y != 0 ? this.y - o.y : this.m - o.m != 0 ? this.m - o.m : this.d - o.d; // 升序
        }
    }

    static Set<Date> dates = new TreeSet<>(); // 去重，排序

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] date = scanner.next().split("/");
        int x = Integer.parseInt(date[0]), y = Integer.parseInt(date[1]), z = Integer.parseInt(date[2]);
        check(x, y, z);
        check(z, x, y);
        check(z, y, x);

        // Arrays.sort(dates);
        for (Date d : dates) {
            System.out.printf("%d-%02d-%02d%n", d.y, d.m, d.d);
        }
    }

    private static void check(int y, int m, int d) {
        if (y >= 60) {
            y += 1900;
        } else {
            y += 2000;
        }

        if (isValid(y, m, d)) {
            dates.add(new Date(y, m, d));
        }
    }

    private static boolean isValid(int y, int m, int d) {
        // 日期是否合法
        return m >= 1 && m <= 12 && d >= 1 && d <= getDays(y, m);
    }
}
