import java.util.*;

// https://www.luogu.com.cn/problem/P2749
public class StarryNight {
    static int H, W;
    static char[][] map;
    static List<Point> points;
    static double[] hashVal = new double[26];
    static int count;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        W = scanner.nextInt();
        H = scanner.nextInt();
        map = new char[H][W];
        for (int i = 0; i < H; i++) {
            map[i] = scanner.next().toCharArray();
        }

        // Flood Fill 找连通块
        // 区分不同星群：Hash
        // 字典序最小
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == '1') {
                    points = new ArrayList<Point>();
                    dfs(i, j);
                    char id = getID();
                    for (Point p : points) {
                        map[p.x][p.y] = id;
                    }
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void dfs(int i, int j) {
        points.add(new Point(i, j));
        map[i][j] = '0';

        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if (x >= 0 && x < H && y >= 0 && y < W && map[x][y] == '1') {
                    dfs(x, y);
                }
            }
        }
    }

    private static char getID() {
        double hash = getHash();
        for (int i = 0; i < count; i++) {
            if (Math.abs(hashVal[i] - hash) < 1e-8) {
                return (char) ('a' + i);
            }
        }
        hashVal[count++] = hash;
        return (char) ('a' + count - 1);
    }

    private static double getHash() {
        // 星群中两两间欧式距离的和
        double hash = 0;
        for (Point p : points) {
            for (Point q : points) {
                hash += Math.sqrt(Math.pow(p.x - q.x, 2) + Math.pow(p.y - q.y, 2));
            }
        }
        return hash;
    }
}
