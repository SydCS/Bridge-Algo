import java.util.Scanner;

// https://www.luogu.com.cn/problem/P8716
public class PalindromeDate {
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

    static int nextDay(int date) {
        int y = date / 10000, m = date / 100 % 100, d = date % 100;
        d++;
        if (d > getDays(y, m)) {
            d = 1;
            m++;
            if (m > 12) {
                m = 1;
                y++;
            }
        }
        return y * 10000 + m * 100 + d;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int date = scanner.nextInt();

        boolean found1 = false, found2 = false;
        while (!found1 || !found2) {
            date = nextDay(date);
            if (check1(Integer.toString(date))) {
                if (!found1) {
                    System.out.println(date);
                    found1 = true;
                }
                if (!found2 && check2(Integer.toString(date))) {
                    System.out.println(date);
                    found2 = true;
                }
            }
        }
    }

    private static boolean check1(String date) {
        // 是否回文
        for (int i = 0, j = date.length() - 1; i < j; i++, j--) {
            if (date.charAt(i) != date.charAt(j))
                return false;
        }
        return true;
    }

    private static boolean check2(String date) {
        // ABAB
        return date.charAt(0) == date.charAt(2) && date.charAt(1) == date.charAt(3) && date.charAt(0) != date.charAt(1);
    }
}