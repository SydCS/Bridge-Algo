
import java.util.Scanner;

// https://www.luogu.com.cn/problem/P8775
public class FrogCrossRiver {
    static int[] stones;
    static int[] prefix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), x = scanner.nextInt();
        stones = new int[n];
        prefix = new int[n];
        for (int i = 1; i < n; i++) {
            stones[i] = scanner.nextInt();
            prefix[i] = prefix[i - 1] + stones[i];
        }

        // 二分
        int l = 1, r = n;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(mid, x)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
        scanner.close();
    }

    private static boolean check(int jump, int x) {
        // 等价于所有长度为 y 的区间内，石头高度和 >= 2x
        for (int i = jump; i < stones.length; i++) {
            if (prefix[i] - prefix[i - jump] < 2 * x) {
                return false;
            }
        }
        return true;
    }
}
