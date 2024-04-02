import java.util.*;

// https://www.luogu.com.cn/problem/P1969
// https://www.luogu.com.cn/problem/P5019
// https://www.luogu.com.cn/problem/P7994
public class AC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] p = new int[N];
        int[] t = new int[N];
        int[] gap = new int[N]; // 差
        for (int i = 0; i < N; i++) {
            p[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            t[i] = scanner.nextInt();
            gap[i] = p[i] - t[i];
        }

        // t -- 区间+-1 --> p
        // 全0 -- 区间+-1 --> gap
        // 全0 -- 端点+-1 --> diff

        int[] diff = new int[N];
        diff[0] = gap[0];
        for (int i = 1; i < N; i++) {
            diff[i] = gap[i] - gap[i - 1];
        }

        // 每次操作，可以让正数的和-1，负数的和+1
        // 求最小操作次数
        int pos = 0, neg = 0;
        for (int i : diff) {
            if (i > 0)
                pos += i;
            else
                neg -= i;
        }
        System.out.println(Math.max(pos, neg));
        scanner.close();
    }
}