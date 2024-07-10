import java.util.Arrays;
import java.util.Scanner;

// https://www.luogu.com.cn/problem/P8687
public class Candy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt();

        int[] bags = new int[N]; // 第i包糖的口味组合

        int states = 1 << M;
        int[] dp = new int[states]; // dp[s]表示得到组合s的最小包数
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            int s = 0;
            for (int j = 0; j < K; j++) {
                s |= (1 << (sc.nextInt() - 1));
            }
            
            bags[i] = s;
            dp[s] = 1;
        }
        sc.close();

        for (int s = 1; s < states; s++) {
            for (int b : bags) {
                dp[s | b] = Math.min(dp[s | b], dp[s] + 1);
            }
        }
        System.out.println(dp[states - 1] == 0x3f3f3f3f ? -1 : dp[states - 1]);
    }
}
