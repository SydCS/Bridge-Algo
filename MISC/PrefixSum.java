import java.util.Scanner;

public class PrefixSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        int[] prefix = new int[n + 1];
        prefix[0] = 0;

        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int m = sc.nextInt();
        while (m-- > 0) {
            System.out.println(-prefix[sc.nextInt() - 1] + prefix[sc.nextInt()]);
        }
        sc.close();
    }
}
