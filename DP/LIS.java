import java.util.Scanner;

// https://acm.hdu.edu.cn/showproblem.php?pid=1257
// https://www.luogu.com.cn/problem/P1020
public class LIS {
    // public static void main(String[] args) {
    // Scanner scanner = new Scanner(System.in);
    // int n = scanner.nextInt();
    // int[] nums = new int[n];
    // for (int i = 0; i < n; i++) {
    // nums[i] = scanner.nextInt();
    // }

    // int[] dp = new int[n]; // dp[i] 表示以 nums[i] 为结尾的LIS的长度
    // int lis = 1;
    // for (int i = 0; i < n; i++) {
    // int max = 1;
    // for (int j = 0; j < i; j++) {
    // if (nums[i] > nums[j]) {
    // max = Math.max(dp[j] + 1, max);
    // }
    // }
    // dp[i] = max;
    // lis = Math.max(dp[i], lis);
    // }
    // System.out.println(lis);
    // scanner.close();
    // }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] heightStr = input.split(" ");
        int len = heightStr.length;
        int[] heights = new int[len];
        for (int i = 0; i < len; i++) {
            heights[i] = Integer.parseInt(heightStr[i]);
        }

        // O(n^2)
        int[] dpLNIS = new int[len]; // Longest Non-Increasing Sequence
        int lnis = 1;
        int[] dpLIS = new int[len]; // Longest Increasing Sequence
        int lis = 1;

        for (int i = 0; i < len; i++) {
            int maxLNIS = 1, maxLIS = 1;
            for (int j = 0; j < i; j++) {
                if (heights[j] >= heights[i]) {
                    maxLNIS = Math.max(dpLNIS[j] + 1, maxLNIS);
                }
                if (heights[j] < heights[i]) {
                    maxLIS = Math.max(dpLIS[j] + 1, maxLIS);
                }
            }
            dpLNIS[i] = maxLNIS;
            dpLIS[i] = maxLIS;
            lnis = Math.max(lnis, maxLNIS);
            lis = Math.max(lis, maxLIS);
        }

        System.out.println(lnis);
        System.out.println(lis);
        scanner.close();
    }
}
