import java.util.Arrays;
import java.util.Scanner;

// https://www.luogu.com.cn/problem/P4552
public class IncDec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n + 1];
        int[] diff = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = scanner.nextInt();
            diff[i] = nums[i] - nums[i - 1];
        }
        System.out.println(Arrays.toString(diff));

        int pos = 0, neg = 0;
        for (int i = 2; i <= n; i++) {
            if (diff[i] > 0) {
                pos += diff[i];
            } else {
                neg -= diff[i];
            }
        }

        System.out.println(Math.max(pos, neg));
        System.out.println(Math.abs(pos - neg) + 1);
        scanner.close();
    }
}
