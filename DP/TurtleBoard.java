import java.util.Scanner;

// https://www.luogu.com.cn/problem/P1541
public class TurtleBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), M = scanner.nextInt();
        int[] board = new int[N];
        for (int i = 0; i < N; i++) {
            board[i] = scanner.nextInt();
        }
        int[] num = new int[5]; // 4种卡片分别的张数
        for (int j = 0; j < M; j++) {
            num[scanner.nextInt()]++;
        }

        int[][][][] dp = new int[41][41][41][41]; // 4种卡片分别使用的张数 (i可由其推导得出) 当前最大得分
        for (int a = 0; a <= num[1]; a++) {
            for (int b = 0; b <= num[2]; b++) {
                for (int c = 0; c <= num[3]; c++) {
                    for (int d = 0; d <= num[4]; d++) {
                        int score = board[a * 1 + b * 2 + c * 3 + d * 4];
                        if (a >= 1)
                            dp[a][b][c][d] = Math.max(dp[a][b][c][d], dp[a - 1][b][c][d]);
                        if (b >= 1)
                            dp[a][b][c][d] = Math.max(dp[a][b][c][d], dp[a][b - 1][c][d]);
                        if (c >= 1)
                            dp[a][b][c][d] = Math.max(dp[a][b][c][d], dp[a][b][c - 1][d]);
                        if (d >= 1)
                            dp[a][b][c][d] = Math.max(dp[a][b][c][d], dp[a][b][c][d - 1]);
                        dp[a][b][c][d] += score;
                    }
                }
            }
        }
        System.out.println(dp[num[1]][num[2]][num[3]][num[4]]);
        scanner.close();
    }
}
