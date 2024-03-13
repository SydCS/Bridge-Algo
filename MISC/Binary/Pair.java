import java.util.*;
import java.util.function.Function;

// https://www.luogu.com.cn/problem/P1102
public class Pair {
    static int[] nums;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int C = scanner.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);

        long count = 0;
        for (int i = 0; i < N; i++) {
            long target = nums[i] + C;
            Function<Integer, Boolean> check1 = n -> nums[n] > target;
            Function<Integer, Boolean> check2 = n -> nums[n] >= target;
            count += binarySearch(check1) - binarySearch(check2);
        }
        System.out.println(count);
        scanner.close();
    }

    public static int binarySearch(Function<Integer, Boolean> check) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check.apply(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
