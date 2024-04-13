import java.util.Arrays;
import java.util.Scanner;

// https://www.luogu.com.cn/problem/P1529
public class CowReturnHome {
    static final int n = 52;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(); // 边数

        // 单源最短路：Dijkstra O(n^2 + m)
        int[][] g = new int[n + 1][n + 1]; // 邻接矩阵
        for (int i = 0; i <= n; i++) {
            Arrays.fill(g[i], 0x3f3f3f3f);
        }
        while (m-- > 0) {
            int u = convert(scanner.next().charAt(0)), v = convert(scanner.next().charAt(0)), w = scanner.nextInt();
            g[u][v] = g[v][u] = Math.min(g[u][v], w); // 可能有重边
        }
        scanner.close();

        int[] dist = new int[n + 1];
        dijkstra(g, dist, 26);

        // 找最近
        int nearest = 1;
        for (int i = 2; i <= 25; i++) {
            if (dist[i] < dist[nearest]) {
                nearest = i;
            }
        }
        System.out.print((char) (nearest - 1 + 'A') + " " + dist[nearest]);
    }

    private static void dijkstra(int[][] g, int[] dist, int source) {
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[source] = 0;

        boolean[] vis = new boolean[n + 1];

        for (int i = 0; i < n - 1; i++) { // 更新 n-1 次
            int u = -1; // 未确定最短路长度的节点中距离最小的节点
            for (int v = 1; v <= n; v++) {
                if (!vis[v] && (u == -1 || dist[v] < dist[u])) {
                    u = v;
                }
            }
            vis[u] = true; // 标记

            // 松弛
            for (int v = 1; v <= n; v++) {
                if (!vis[v]) {
                    dist[v] = Math.min(dist[v], dist[u] + g[u][v]);
                }
            }
        }
    }

    private static int convert(char c) {
        // 字母 --> 数字 1~26 27~52
        if (c <= 'Z')
            return c - 'A' + 1;
        else
            return c - 'a' + 27;
    }
}
