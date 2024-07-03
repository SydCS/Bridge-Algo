import java.util.Arrays;
import java.util.Scanner;

// https://www.luogu.com.cn/problem/P3366
public class Prim {
    static class Edge {
        int x;
        int y;
        int w;

        public Edge(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
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

        // Prim
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        boolean[] visited = new boolean[N + 1];

        int mstCost = 0;
        for (int i = 0; i < N; i++) {
            int x = -1;
            for (int j = 1; j <= N; j++) {
                if (!visited[j] && (x == -1 || dist[j] < dist[x])) {
                    x = j;
                }
            }

            visited[x] = true;
            mstCost += dist[x];

            for (Edge edge : edges) {
                if (edge.x == x && !visited[edge.y] && edge.w < dist[edge.y]) {
                    dist[edge.y] = edge.w;
                }
                if (edge.y == x && !visited[edge.x] && edge.w < dist[edge.x]) {
                    dist[edge.x] = edge.w;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("orz");
                return;
            }
        }
        System.out.println(mstCost);
    }
}
