import java.util.Arrays;
import java.util.Scanner;

// https://www.acwing.com/problem/content/description/3468/
public class VirusTrack {
    static class Edge {
        int to; // 边的终点
        int next; // 下一条边的编号

        public Edge(int to, int next) {
            this.to = to;
            this.next = next;
        }
    }

    // 链式前向星
    static Edge[] edges;
    static int[] head;
    static int idx;

    private static void addEdge(int u, int v) {
        edges[idx].next = head[u];
        edges[idx].to = v;
        head[u] = idx;
        idx++;
    }

    static boolean[] haveFather;
    static int[] son;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        edges = new Edge[N];
        for (int i = 0; i < N; i++) {
            edges[i] = new Edge(-1, -1);
        }
        head = new int[N];
        Arrays.fill(head, -1);
        idx = 0;

        haveFather = new boolean[N];

        for (int i = 0; i < N; i++) {
            int k = scanner.nextInt();
            while (k-- > 0) {
                int v = scanner.nextInt();
                addEdge(i, v);
                haveFather[v] = true;
            }
        }
        scanner.close();

        // 找根节点
        int root = 0;
        while (haveFather[root]) {
            root++;
        }

        son = new int[N]; // 存下来
        Arrays.fill(son, -1);

        // 从根节点开始的最长路径长度
        int dist = dfs(root);
        System.out.println(dist);

        // 输出最长的路径
        System.out.print(root);
        for (int cur = son[root]; cur != -1; cur = son[cur]) {
            System.out.print(" " + cur);
        }
    }

    private static int dfs(int u) {
        int maxDist = 0;

        for (int e = head[u]; e != -1; e = edges[e].next) { // 遍历出边
            int v = edges[e].to; // 子节点
            int d = dfs(v);
            if (d > maxDist || (d == maxDist && v < son[u])) { // 字典序
                maxDist = d;
                son[u] = v;
            }
        }

        return maxDist + 1; // dp[i] = max{dp[...]} + 1
    }
}
