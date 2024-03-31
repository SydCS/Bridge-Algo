import java.util.Scanner;

// https://www.luogu.com.cn/problem/P1508
public class Eat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt();
        int[][] arr = new int[m + 1][n + 2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        // 从上至下
        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] += Math.max(arr[i - 1][j - 1], Math.max(arr[i - 1][j], arr[i - 1][j + 1]));
            }
        }
        System.out.println(Math.max(arr[m][(n - 1) / 2], Math.max(arr[m][(n - 1) / 2 + 1], arr[m][(n - 1) / 2 + 2])));
        scanner.close();
    }
}
