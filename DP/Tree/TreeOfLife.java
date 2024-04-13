import java.util.*;

// https://www.luogu.com.cn/problem/P1122
// https://www.luogu.com.cn/problem/P8625
public class TreeOfLife {
    static List<Integer>[] adj; // 邻接表
    static int[] score;
    static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 节点数
        score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = sc.nextInt();
        }

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int j = 1; j < n; j++) {
            int u = sc.nextInt(), v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }
        sc.close();

        // 找到无向图中节点权值之和最大的连通块
        dp = new long[n + 1]; // dp[i] 表示在以 i 为根的子树中包含 i 的所有连通块的权值和的最大值
        dfs(1, -1);

        long max = 0; // (两题些微不同)
        for (int i = 1; i <= n; i++) {
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }

    private static void dfs(int root, int father) {
        // dp[i] = score[i] + max(dp[v], 0), v ∈ adj[i]
        dp[root] = score[root];

        for (int v : adj[root]) {
            if (v != father) {
                dfs(v, root);
                dp[root] += Math.max(dp[v], 0);
            }
        }
    }
}
