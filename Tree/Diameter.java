import java.util.*;

// https://www.luogu.com.cn/problem/P8602
public class Diameter {
    static class Edge {
        int to, dist;

        public Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    static List<Edge>[] adj; // 邻接表
    static int[] dist;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            int p = scanner.nextInt(), q = scanner.nextInt(), d = scanner.nextInt();
            // 双向建边
            adj[p].add(new Edge(q, d));
            adj[q].add(new Edge(p, d));
        }
        scanner.close();

        // 求树的直径：两次 DFS
        dist = new int[n + 1];
        dfs(1, 0, 0);
        int furthest = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > dist[furthest]) {
                furthest = i;
            }
        }

        dist = new int[n + 1];
        dfs(furthest, 0, 0);
        int diameter = 0;
        for (int i = 1; i <= n; i++) {
            diameter = Math.max(diameter, dist[i]);
        }
        System.out.println(diameter * 10L + ((long) diameter * (long) (diameter + 1)) / 2);
    }

    private static void dfs(int u, int father, int length) {
        dist[u] = length;

        for (Edge e : adj[u]) {
            if (e.to != father) {
                dfs(e.to, u, length + e.dist);
            }
        }
    }
}
