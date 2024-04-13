import java.util.*;

// https://www.luogu.com.cn/problem/P3379
public class LCA {
    static List<Integer>[] adj; // 邻接表

    static int[] depth;
    static int[][] st;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), M = scanner.nextInt(), S = scanner.nextInt();
        adj = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            int u = scanner.nextInt(), v = scanner.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        // DFS，构建 ST 表
        depth = new int[N + 1]; // 深度
        st = new int[N + 1][20]; // 从 u 节点向上跳 2^k 层的祖先节点
        dfs(S, 0);

        // 求 LCA
        while (M-- > 0) {
            int a = scanner.nextInt(), b = scanner.nextInt();
            System.out.println(lca(a, b));
        }
        scanner.close();
    }

    private static void dfs(int u, int father) {
        depth[u] = depth[father] + 1;

        // 向上跳 1 2 4 ... 层
        st[u][0] = father;
        for (int k = 1; k <= 19; k++) {
            st[u][k] = st[st[u][k - 1]][k - 1];
        }

        for (int v : adj[u]) {
            if (v != father) {
                dfs(v, u);
            }
        }
    }

    private static int lca(int u, int v) {
        // swap
        if (depth[u] < depth[v]) {
            int t = u;
            u = v;
            v = t;
        }

        // 先跳到同一层
        for (int k = 19; k >= 0; k--) {
            if (depth[st[u][k]] >= depth[v]) {
                u = st[u][k];
            }
        }

        if (u == v)
            return u;

        // 再一起跳到 LCA 的下一层
        for (int k = 19; k >= 0; k--) {
            if (st[u][k] != st[v][k]) {
                u = st[u][k];
                v = st[v][k];
            }
        }

        return st[u][0];
    }
}
