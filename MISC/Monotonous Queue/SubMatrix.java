import java.util.*;

// https://www.acwing.com/problem/content/4967/
public class SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt(), a = scanner.nextInt(), b = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // 二维 单调队列
        // 转换为两个一维

        // 对于每一行，求长度为 b 的窗口的最值 O(n * m)
        int[][] maxRow = new int[n][m - b + 1];
        int[][] minRow = new int[n][m - b + 1];
        for (int i = 0; i < n; i++) {
            Deque<Integer> q1 = new LinkedList<>();
            Deque<Integer> q2 = new LinkedList<>();
            for (int j = 0; j < m; j++) {
                while (!q1.isEmpty() && matrix[i][j] >= matrix[i][q1.peekLast()]) {
                    q1.pollLast();
                }
                q1.addLast(j);

                while (!q2.isEmpty() && matrix[i][j] <= matrix[i][q2.peekLast()]) {
                    q2.pollLast();
                }
                q2.addLast(j);

                if (j - q1.peekFirst() >= b) {
                    q1.pollFirst();
                }

                if (j - q2.peekFirst() >= b) {
                    q2.pollFirst();
                }

                if (j >= b - 1) {
                    maxRow[i][j - b + 1] = matrix[i][q1.peekFirst()];
                    minRow[i][j - b + 1] = matrix[i][q2.peekFirst()];
                }
            }
        }

        // 再对于每一列，求高度为 a 的窗口的最值 O(n * m)
        int[][] maxRowCol = new int[n - a + 1][m - b + 1];
        int[][] minRowCol = new int[n - a + 1][m - b + 1];
        for (int j = 0; j < m - b + 1; j++) {
            Deque<Integer> q1 = new LinkedList<>();
            Deque<Integer> q2 = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                while (!q1.isEmpty() && maxRow[i][j] >= maxRow[q1.peekLast()][j]) {
                    q1.pollLast();
                }
                q1.addLast(i);

                while (!q2.isEmpty() && minRow[i][j] <= minRow[q2.peekLast()][j]) {
                    q2.pollLast();
                }
                q2.addLast(i);

                if (i - q1.peekFirst() >= a) {
                    q1.pollFirst();
                }

                if (i - q2.peekFirst() >= a) {
                    q2.pollFirst();
                }

                if (i >= a - 1) {
                    maxRowCol[i - a + 1][j] = maxRow[q1.peekFirst()][j];
                    minRowCol[i - a + 1][j] = minRow[q2.peekFirst()][j];
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < n - a + 1; i++) {
            for (int j = 0; j < m - b + 1; j++) {
                ans += (long) maxRowCol[i][j] * (long) minRowCol[i][j];
                ans %= 998244353;
            }
        }
        System.out.println(ans);
        scanner.close();
    }
}
