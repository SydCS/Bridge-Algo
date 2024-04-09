import java.util.*;

// https://www.acwing.com/problem/content/4410/
public class Mine {
    static class Bomb {
        int x, y, r;
        boolean bombed;

        public Bomb(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
            bombed = false;
        }
    }

    static Bomb[] bombs;
    static Map<List<Integer>, List<Integer>> map; // 坐标 -> 炸弹编号
    static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        bombs = new Bomb[n];
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt(), r = scanner.nextInt();
            bombs[i] = new Bomb(x, y, r);
            if (map.containsKey(Arrays.asList(x, y))) {
                map.get(Arrays.asList(x, y)).add(i);
            } else {
                map.put(Arrays.asList(x, y), new ArrayList<Integer>(Arrays.asList(i)));
            }
        }

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt(), r = scanner.nextInt();
            // for (Bomb b : bombs) {
            // if (!b.bombed && (x - b.x) * (x - b.x) + (y - b.y) * (y - b.y) <= r * r) {
            // dfs(b);
            // }
            // }
            for (int xx = x - r; xx <= x + r; xx++) {
                for (int yy = y - r; yy <= y + r; yy++) {
                    if ((x - xx) * (x - xx) + (y - yy) * (y - yy) <= r * r && map.containsKey(Arrays.asList(xx, yy))) {
                        for (int j : map.get(Arrays.asList(xx, yy))) {
                            Bomb b = bombs[j];
                            if (!b.bombed)
                                dfs(b);
                        }
                    }
                }
            }
        }
        System.out.println(count);
        scanner.close();
    }

    private static void dfs(Bomb bomb) {
        count++;
        bomb.bombed = true;

        // for (Bomb b : bombs) {
        // if (!b.bombed && (bomb.x - b.x) * (bomb.x - b.x) + (bomb.y - b.y) * (bomb.y -
        // b.y) <= bomb.r * bomb.r) {
        // dfs(b);
        // }
        // }
        for (int nx = bomb.x - bomb.r; nx <= bomb.x + bomb.r; nx++) {
            for (int ny = bomb.y - bomb.r; ny <= bomb.y + bomb.r; ny++) {
                if ((bomb.x - nx) * (bomb.x - nx) + (bomb.y - ny) * (bomb.y - ny) <= bomb.r * bomb.r
                        && map.containsKey(Arrays.asList(nx, ny))) {
                    for (int j : map.get(Arrays.asList(nx, ny))) {
                        Bomb b = bombs[j];
                        if (!b.bombed)
                            dfs(b);
                    }
                }
            }
        }
    }
}
