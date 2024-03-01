import java.util.Scanner;

public class UnionFind {
    private static int[] parent; // 并查集的父节点数组

    // 并查集的查找操作，找到元素x的根节点
    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 路径压缩
        }
        return parent[x];
    }

    // 并查集的合并操作，将元素x和元素y所在的集合合并
    private static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot != yRoot) {
            parent[xRoot] = yRoot; // 将一个根节点连接到另一个根节点上
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt(); // 城镇数目
            if (N == 0)
                break; // 当N为0时，输入结束
            int M = scanner.nextInt(); // 道路数目

            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i; // 初始化并查集
            }

            for (int i = 0; i < M; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                union(a, b); // 根据道路连接城镇
            }

            int components = 0; // 连通分量的数量
            for (int i = 1; i <= N; i++) {
                if (parent[i] == i) {
                    components++;
                }
            }
            System.out.println(components - 1); // 输出最少还需要建设的道路数目
        }
        scanner.close();
    }
}
