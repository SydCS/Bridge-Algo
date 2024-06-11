import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        int[] dp = new int[n + 1]; // 以 nums[i] 结尾的最大字段和
        int max = 0xc0c0c0c0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + arr[i] : arr[i];
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
