import java.util.Arrays;
import java.util.Scanner;

// https://www.luogu.com.cn/problem/P1209
public class RepairBarn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt(), S = scanner.nextInt(), C = scanner.nextInt();
        int[] barns = new int[C];
        for (int i = 0; i < C; i++) {
            barns[i] = scanner.nextInt();
        }
        Arrays.sort(barns);
        scanner.close();

        // 转换：M 个线段覆盖 1，长度和最短 ---> 挖出 M-1 个间隔
        // 贪心：挖去最长的连续 0

        int totalLength = barns[C - 1] - barns[0] + 1;

        int[] gap = new int[C - 1]; // 中间连续 0 的数量
        for (int i = 0; i < C - 1; i++) {
            gap[i] = barns[i + 1] - barns[i] - 1;
        }
        Arrays.sort(gap);

        for (int m = 1; m <= M - 1 && m <= C - 1; m++) {
            totalLength -= gap[C - 1 - m];
        }
        System.out.println(totalLength);
    }
}