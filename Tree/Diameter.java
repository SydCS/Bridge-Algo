import java.util.*;

// https://www.luogu.com.cn/problem/P8602
public class Diameter {
    static List<Edge>[] tree;

    static class Edge {
        int to, dist;

        public Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int p = scanner.nextInt(), q = scanner.nextInt(), d = scanner.nextInt();
            tree[p].add(new Edge(q, d));
            tree[q].add(new Edge(p, d));
        }

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
        scanner.close();
    }

    static int[] dist;

    private static void dfs(int u, int father, int length) {
        dist[u] = length;

        for (Edge e : tree[u]) {
            if (e.to != father) {
                dfs(e.to, u, e.dist + length);
            }
        }
    }
}
