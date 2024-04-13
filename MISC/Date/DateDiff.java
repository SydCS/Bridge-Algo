import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

// https://www.acwing.com/problem/content/3501/
public class DateDiff {
    static final int[] months = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line1 = scanner.nextLine(), line2 = scanner.nextLine();

            LocalDate date1 = LocalDate.parse(line1, DateTimeFormatter.ofPattern("yyyyMMdd"));
            LocalDate date2 = LocalDate.parse(line2, DateTimeFormatter.ofPattern("yyyyMMdd"));
            System.out.println(Math.abs(ChronoUnit.DAYS.between(date1, date2)) + 1);

            int y1 = Integer.parseInt(line1.substring(0, 4)), m1 = Integer.parseInt(line1.substring(4, 6)),
                    d1 = Integer.parseInt(line1.substring(6, 8));
            int y2 = Integer.parseInt(line2.substring(0, 4)), m2 = Integer.parseInt(line2.substring(4, 6)),
                    d2 = Integer.parseInt(line2.substring(6, 8));
            System.out.println(Math.abs(count(y1, m1, d1) - count(y2, m2, d2)) + 1);
        }
        scanner.close();
    }

    private static int count(int y, int m, int d) { // 从第1天到第y年m月d日的天数
        int count = 0;
        for (int i = 1; i <= y - 1; i++)
            count += 365 + isLeapYear(i);
        for (int j = 1; j <= m - 1; j++)
            count += getDays(y, j);
        return count + d;
    }
}