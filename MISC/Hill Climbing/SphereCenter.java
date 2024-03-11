import java.util.Scanner;

public class SphereCenter {
    static int n;
    static double[][] points;
    static double[] center, adjust, dist;
    static double total;

    static void check() {
        total = 0;
        for (int i = 1; i <= n + 1; i++) {
            dist[i] = 0;
            adjust[i] = 0;
            for (int j = 1; j <= n; j++)
                dist[i] += (points[i][j] - center[j]) * (points[i][j] - center[j]);
            dist[i] = Math.sqrt(dist[i]); // 欧氏距离
            total += dist[i];
        }
        total /= (n + 1); // 平均
        for (int i = 1; i <= n + 1; i++)
            for (int j = 1; j <= n; j++)
                adjust[j] += (dist[i] - total) * (points[i][j] - center[j]) / total; // 对于每个维度把修改值更新掉，欧氏距离差*差值贡献
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        points = new double[10001][1001];
        center = new double[10001];
        dist = new double[10001];
        adjust = new double[100001];

        for (int i = 1; i <= n + 1; i++)
            for (int j = 1; j <= n; j++) {
                points[i][j] = scanner.nextDouble();
                center[j] += points[i][j];
            }

        for (int j = 1; j <= n; j++)
            center[j] /= (n + 1); // 初始化

        for (double t = 10001; t >= 0.0001; t *= 0.99995) { // 不断降温
            check();
            for (int i = 1; i <= n; i++)
                center[i] += adjust[i] * t; // 修改
        }

        for (int j = 1; j <= n; j++)
            System.out.printf("%.3f ", center[j]);

        scanner.close();
    }
}
