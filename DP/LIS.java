import java.util.Scanner;

// https://acm.hdu.edu.cn/showproblem.php?pid=1257
public class LIS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] dp = new int[n]; // dp[i] 表示以 nums[i] 为结尾的最长上升子序列的长度
        int lis = 1;
        for (int i = 0; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(dp[j] + 1, max);
                }
            }
            dp[i] = max;
            lis = Math.max(dp[i], lis);
        }
        System.out.println(lis);
        scanner.close();
    }
}
