import java.util.Arrays;
import java.util.Scanner;

// https://www.luogu.com.cn/problem/P3366
public class Kruskal {
    static class Edge implements Comparable<Edge> {
        int x;
        int y;
        int w;

        public Edge(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {
            return this.w - e.w; // 按边权升序
        }
    }

    static int[] parent;

    private static int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    private static void union(int xRoot, int yRoot) {
        parent[xRoot] = yRoot;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), M = scanner.nextInt();

        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt(), w = scanner.nextInt();
            edges[i] = new Edge(x, y, w);
        }
        scanner.close();

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // Kruskal
        Arrays.sort(edges);

        int mstCost = 0, count = 0;
        for (Edge e : edges) {
            int xRoot = find(e.x);
            int yRoot = find(e.y);
            if (xRoot != yRoot) {
                union(xRoot, yRoot);
                mstCost += e.w;
                count++;
            }
        }
        System.out.println(count == N - 1 ? mstCost : "orz");
    }
}
