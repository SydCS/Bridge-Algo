package Prefix;

import java.util.Scanner;

// https://www.luogu.com.cn/problem/P1115
public class MaxSubSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n + 1];
        int[] prefix = new int[n + 1]; // 可以理解为前缀和/DP

        int max = 0xc0c0c0c0;
        for (int i = 1; i <= n; i++) {
            nums[i] = scanner.nextInt();
            if (prefix[i - 1] > 0)
                prefix[i] = prefix[i - 1] + nums[i];
            else
                prefix[i] = nums[i];
            max = Math.max(max, prefix[i]);
        }
        System.out.println(max);
        scanner.close();
    }
}
