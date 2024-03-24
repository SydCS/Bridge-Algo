package Contribution;
import java.util.Scanner;

// https://www.luogu.com.cn/problem/P7993
public class LonelyCow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        char[] cows = new char[N];
        String s = sc.next();
        for (int i = 0; i < N; i++) {
            cows[i] = s.charAt(i);
        }

        int[] leftG = new int[N], leftH = new int[N]; // 左边有几个 G H
        for (int i = 0; i < N - 1; i++) {
            if (cows[i] == 'G') {
                leftG[i + 1] = leftG[i] + 1;
                leftH[i + 1] = 0;
            } else {
                leftH[i + 1] = leftH[i] + 1;
                leftG[i + 1] = 0;
            }
        }

        int[] rightG = new int[N], rightH = new int[N]; // 右边有几个 G H
        for (int i = N - 1; i > 0; i--) {
            if (cows[i] == 'G') {
                rightG[i - 1] = rightG[i] + 1;
                rightH[i - 1] = 0;
            } else {
                rightH[i - 1] = rightH[i] + 1;
                rightG[i - 1] = 0;
            }
        }

        long lonely = 0;
        // 贡献法：从奶牛角度出发
        for (int i = 0; i < N; i++) {
            if (cows[i] == 'H') {
                lonely += (long) leftG[i] * rightG[i] + Math.max(leftG[i] - 1, 0) + Math.max(rightG[i] - 1, 0);
            } else {
                lonely += (long) leftH[i] * rightH[i] + Math.max(leftH[i] - 1, 0) + Math.max(rightH[i] - 1, 0);
            }
        }
        System.out.println(lonely);
        sc.close();
    }
}
