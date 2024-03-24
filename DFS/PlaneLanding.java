import java.util.*;

// https://www.luogu.com.cn/problem/P9241
public class PlaneLanding {
    static class Plane {
        public int arrival; // 到达时间
        public int duration; // 剩余燃料可以继续盘旋的时间
        public int landing; // 降落所需时间
        public boolean visited;

        Plane(int a, int d, int l) {
            this.arrival = a;
            this.duration = d;
            this.landing = l;
            this.visited = false;
        }
    }

    static Plane[] planes;
    static boolean canLandAll;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 测试数据的组数

        while (T-- > 0) {
            int N = scanner.nextInt(); // 飞机数量
            planes = new Plane[N];
            for (int i = 0; i < N; i++) {
                planes[i] = new Plane(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            }

            // 不好确定顺序，直接开搜
            canLandAll = false;
            dfs(0, 0);
            System.out.println(canLandAll ? "YES" : "NO");
        }
        scanner.close();
    }

    private static void dfs(int index, int currentTime) {
        if (index == planes.length) {
            canLandAll = true;
            return;
        }

        for (Plane plane : planes) {
            if (!plane.visited) {
                int startTime = Math.max(currentTime, plane.arrival);
                if (startTime <= plane.arrival + plane.duration) {
                    plane.visited = true;
                    dfs(index + 1, startTime + plane.landing);
                    plane.visited = false;
                }
            }
        }
    }
}
