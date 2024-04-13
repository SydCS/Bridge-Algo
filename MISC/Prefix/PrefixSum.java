import java.util.Scanner;

// https://www.luogu.com.cn/problem/B3612 前缀和模板题
public class PrefixSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        int[] prefix = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int m = sc.nextInt();
        while (m-- > 0) {
            int l = sc.nextInt(), r = sc.nextInt();
            System.out.println(prefix[r] - prefix[l - 1]);
        }
        sc.close();
    }
}
