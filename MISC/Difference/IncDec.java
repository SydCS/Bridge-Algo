import java.util.Arrays;
import java.util.Scanner;

// https://www.luogu.com.cn/problem/P4552
public class IncDec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] nums = new long[n + 1];
        long[] diff = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = scanner.nextLong();
            diff[i] = nums[i] - nums[i - 1];
        }
        System.out.println(Arrays.toString(diff));

        // diff --> X000...
        long pos = 0, neg = 0; // 不开 long 见祖宗
        for (int i = 2; i <= n; i++) {
            if (diff[i] > 0)
                pos += diff[i];
            else
                neg -= diff[i];
        }

        System.out.println(Math.max(pos, neg)); // 操作次数 min(pos, neg) + |pos - neg|
        System.out.println(Math.abs(pos - neg) + 1); // 后面 |pos - neg| 次操作，加减 diff[1] 或者 最后面延的一位
        scanner.close();
    }
}