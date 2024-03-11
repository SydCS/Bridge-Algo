import java.util.*;

// https://www.luogu.com.cn/problem/P1083
public class ClassRoom {
    static int n;
    static int m;
    static int[] rooms;
    static Order[] orders;

    static class Order {
        int d, s, t; // 所需教室数量，开始的天数，结束的天数

        public Order(int d, int s, int t) {
            this.d = d;
            this.s = s;
            this.t = t;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 天数
        m = scanner.nextInt(); // 订单数量

        rooms = new int[n + 1]; // 教室数量数组，从1开始计数
        for (int i = 1; i <= n; i++) {
            rooms[i] = scanner.nextInt();
        }

        orders = new Order[m + 1]; // 订单数组
        for (int i = 1; i <= m; i++) {
            orders[i] = new Order(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        // 二分查找无法满足的订单
        int l = 1, r = m + 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (!check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (r == m + 1) {
            // 如果所有订单均可满足，输出0
            System.out.println("0");
        } else {
            // 如果有订单无法满足，输出-1 + 该无法满足的订单编号
            System.out.println("-1");
            System.out.println(r);
        }
        scanner.close();
    }

    public static boolean check(int k) {
        // 差分
        long[] diff = new long[n + 2];
        for (int i = 1; i <= k; i++) {
            diff[orders[i].s] += orders[i].d;
            diff[orders[i].t + 1] -= orders[i].d;
        }

        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += diff[i];
            if (sum > rooms[i]) {
                return false;
            }
        }
        return true;
    }
}
