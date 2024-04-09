import java.util.Arrays;
import java.util.Scanner;

// https://www.acwing.com/problem/content/description/1225/
// https://www.luogu.com.cn/problem/P8636
public class MaxRatio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] nums = new long[N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextLong();
        }
        scanner.close();
        Arrays.sort(nums);

        long[] ups = new long[N], downs = new long[N]; // 分子 分母
        for (int i = 1; i < N; i++) {
            if (nums[i] != nums[i - 1]) {
                long gcd = gcd(nums[i], nums[i - 1]);
                ups[count] = nums[i] / gcd;
                downs[count] = nums[i - 1] / gcd;
                count++;
            }
        }

        long up = ups[0], down = downs[0];
        for (int i = 1; i < count; i++) {
            up = gcdSub(up, ups[i]);
            down = gcdSub(down, downs[i]);
        }
        System.out.println(up + "/" + down);
    }

    private static long gcdSub(long a, long b) {
        // a 和 b 可以表示成 p 的 i 次方和 j 次方时，求 p ^ gcd(i, j)

        // 更相减损
        if (a < b) {
            long tmp = a;
            a = b;
            b = tmp;
        }

        if (b == 1) {
            return a;
        }

        return gcdSub(b, a / b); // 大-小 ---> 大/小
    }

    private static long gcd(long a, long b) {
        // 辗转相除
        return b == 0 ? a : gcd(b, a % b);
    }
}