import java.util.Arrays;
import java.util.Scanner;

// https://acm.hdu.edu.cn/showproblem.php?pid=2988
public class DarkRoads {
    static class Road implements Comparable<Road> {
        int x;
        int y;
        int w;

        public Road(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.w = z;
        }

        @Override
        public int compareTo(Road r) {
            return this.w - r.w; // 按边权升序
        }
    }

    static class Set {
        int parent;
        int rank;

        public Set(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    private static Road[] roads;
    private static Set[] set;

    private static int find(int i) {
        if (set[i].parent != i) {
            set[i].parent = find(set[i].parent);
        }
        return set[i].parent;
    }

    private static void union(int xRoot, int yRoot) {
        if (set[xRoot].rank < set[yRoot].rank)
            set[xRoot].parent = yRoot;
        else if (set[xRoot].rank > set[yRoot].rank)
            set[yRoot].parent = xRoot;
        else {
            set[yRoot].parent = xRoot;
            set[xRoot].rank++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            if (m == 0 && n == 0)
                break;

            set = new Set[m];
            for (int i = 0; i < m; i++) {
                set[i] = new Set(i, 0);
            }

            roads = new Road[n];
            int totalCost = 0;
            while (n-- > 0) {
                int x = scanner.nextInt(), y = scanner.nextInt(), z = scanner.nextInt();
                roads[n] = new Road(x, y, z);
                totalCost += z;
            }
            Arrays.sort(roads);

            // Kruskal
            int mstCost = 0;
            for (Road r : roads) {
                int xRoot = find(r.x);
                int yRoot = find(r.y);
                if (xRoot != yRoot) {
                    union(xRoot, yRoot);
                    mstCost += r.w;
                }
            }
            System.out.println(totalCost - mstCost);
        }
        scanner.close();
    }
}
