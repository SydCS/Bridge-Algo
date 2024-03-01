import java.util.Scanner;

public class LIS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] dp = new int[nums.length];

        int lis = 1;
        for (int i = 0; i < nums.length; i++) {
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
