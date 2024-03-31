import java.util.Scanner;

// https://www.acwing.com/problem/content/1264/
public class Fishing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] fish = new int[N];
        int[] dec = new int[N];
        int[] dist = new int[N];
        int[] prefix = new int[N];
        for (int i = 0; i < N; i++) {
            fish[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            dec[i] = scanner.nextInt();
        }
        for (int i = 1; i <= N - 1; i++) {
            dist[i] = scanner.nextInt();
            prefix[i] = prefix[i - 1] + dist[i];
        }
        int T = scanner.nextInt();

        // 贪心：一条直线走到头，不会反复横跳
        // 枚举：顺着走到i处
        int count = 0;
        for (int i = 0; i < N; i++) {
            // 钓鱼时间 = 总时间 - 走路时间
            int time = T - prefix[i];
            // 多路归并
            count = Math.max(count, merge(fish, dec, i, time));
        }
        System.out.println(count);
        scanner.close();
    }

    private static int merge(int[] fish, int[] dec, int i, int time) {
        int count = 0;
        int[] spend = new int[i + 1]; // 每个鱼塘分别的钓鱼时间
        for (int t = 0; t < time; t++) {
            int pick = 0; // 选择在哪个鱼塘钓
            int max = 0;
            for (int n = 0; n <= i; n++) {
                if (fish[n] - dec[n] * spend[n] > max) {
                    max = fish[n] - dec[n] * spend[n];
                    pick = n;
                }
            }
            count += max;
            spend[pick]++;
        }
        return count;
    }

}
