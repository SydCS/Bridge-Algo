import java.util.Scanner;

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
    static int ans;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        bombs = new Bomb[n];
        for (int i = 0; i < n; i++) {
            bombs[i] = new Bomb(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt(), r = scanner.nextInt();
            for (Bomb b : bombs) {
                if (!b.bombed && (x - b.x) * (x - b.x) + (y - b.y) * (y - b.y) <= r * r) {
                    dfs(b);
                }
            }
        }
        System.out.println(ans);
        scanner.close();
    }

    private static void dfs(Bomb bomb) {
        ans++;
        bomb.bombed = true;
        for (Bomb b : bombs) {
            if (!b.bombed && (bomb.x - b.x) * (bomb.x - b.x) + (bomb.y - b.y) * (bomb.y - b.y) <= bomb.r * bomb.r) {
                dfs(b);
            }
        }
    }
}
