import java.util.Scanner;

// https://www.luogu.com.cn/problem/P1387
public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[][] matrix = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // 二维前缀和
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                matrix[i][j] += matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1];
            }
        }

        // 子矩阵和
        for (int len = Math.min(n, m); len >= 1; len--) {
            for (int i = 1; i + len - 1 <= n; i++) {
                for (int j = 1; j + len - 1 <= m; j++) {
                    if (matrix[i + len - 1][j + len - 1] - matrix[i - 1][j + len - 1] - matrix[i + len - 1][j - 1]
                            + matrix[i - 1][j - 1] == len * len) {
                        System.out.println(len);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(0);
    }
}
