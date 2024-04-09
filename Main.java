import java.util.*;

// https://www.acwing.com/problem/content/description/3468/
public class Main {
    static List<Integer>[] adj; // 邻接表

    static int[] son;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList();
        }

        boolean[] haveFather = new boolean[N];

        for (int i = 0; i < N; i++) {
            int k = scanner.nextInt();
            while (k-- > 0) {
                int v = scanner.nextInt();
                adj[i].add(v);
                haveFather[v] = true;
            }
        }

        // 找根节点
        int root = 0;
        while (haveFather[root]) {
            root++;
        }

        son = new int[N];
        Arrays.fill(son, -1);

        // 从根节点开始的最大路径长度
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

        for (int v : adj[u]) { // 遍历子节点
            int d = dfs(v);
            if (d > maxDist || (d == maxDist && v < son[u])) { // 字典序
                maxDist = d;
                son[u] = v;
            }
        }

        return maxDist + 1;
    }
}
