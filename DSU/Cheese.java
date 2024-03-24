import java.util.*;

// https://www.luogu.com.cn/problem/P3958
public class Cheese {
    static class Point {
        long x, y, z;

        Point(long x, long y, long z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int[] parents;

    static int find(int x) {
        return parents[x] == x ? x : (parents[x] = find(parents[x]));
    }

    static void union(int x, int y) {
        parents[find(x)] = find(y);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt(), h = scanner.nextInt();
            long r = scanner.nextLong();
            Point[] points = new Point[n + 1];
            parents = new int[n + 2]; // 0, n + 1 表示触底和触顶
            for (int i = 0; i < n + 2; i++) {
                parents[i] = i;
            }
            for (int i = 1; i < n + 1; i++) {
                long x = scanner.nextLong(), y = scanner.nextLong(), z = scanner.nextLong();
                points[i] = new Point(x, y, z);
                if (Math.abs(z) <= r) {
                    union(i, 0);
                }
                if (Math.abs(z - h) <= r) {
                    union(i, n + 1);
                }
            }

            // 并
            for (int i = 2; i < n + 1; i++) {
                for (int j = 1; j < i; j++) {
                    if (connected(points[i], points[j], r)) {
                        union(i, j);
                    }
                }
            }

            // 判断顶、底是否连通
            if (find(n + 1) == find(0)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        scanner.close();
    }

    private static boolean connected(Point p1, Point p2, long r) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y)
                + (p1.z - p2.z) * (p1.z - p2.z) <= 4 * r * r;
    }
}
