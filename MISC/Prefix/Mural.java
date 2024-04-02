import java.util.Scanner;

// https://www.acwing.com/problem/content/description/564/
public class Mural {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 读取测试用例的数量
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt(); // 读取每个测试用例的墙段数量
            String wall = scanner.next(); // 读取每段墙面的美观评分
            int[] prefix = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                prefix[i] = prefix[i - 1] + (wall.charAt(i - 1) - '0');
            }

            int len = (N + 1) / 2; // 最终剩余的墙段长度
            int maxScore = 0;
            for (int i = len; i <= N; i++) {
                int score = -prefix[i - len] + prefix[i];
                maxScore = Math.max(maxScore, score);
            }
            System.out.println("Case #" + t + ": " + maxScore);
        }
        scanner.close();
    }
}
