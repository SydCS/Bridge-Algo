import java.util.*;

// https://www.luogu.com.cn/problem/P9242
public class Loong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.next();
        }
        scanner.close();

        int[] dp = new int[10]; // 转换问题：dp[k] 表示以 k 为结尾的接龙数列的长度
        for (String s : nums) {
            int start = s.charAt(0) - '0';
            int end = s.charAt(s.length() - 1) - '0';
            dp[end] = Math.max(dp[end], dp[start] + 1);
        }

        System.out.println(n - Arrays.stream(dp).max().getAsInt());
    }
}