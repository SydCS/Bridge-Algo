import java.util.*;
import java.util.function.Function;

// https://www.luogu.com.cn/problem/P1678
public class Application {
    static int[] schools;
    static int[] students;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        schools = new int[m];
        for (int i = 0; i < m; i++) {
            schools[i] = scanner.nextInt();
        }
        Arrays.sort(schools);
        students = new int[n];
        for (int i = 0; i < n; i++) {
            students[i] = scanner.nextInt();
        }

        long count = 0;
        for (int i = 0; i < n; i++) {
            long target = students[i];
            Function<Integer, Boolean> check = k -> schools[k] >= target;
            int k = binarySearch(check);
            count += Math.min(Math.abs(schools[Math.min(m - 1, k)] - target),
                    Math.abs(schools[Math.max(0, k - 1)] - target));
        }
        System.out.println(count);
        scanner.close();
    }

    public static int binarySearch(Function<Integer, Boolean> check) {
        int l = 0, r = schools.length;
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
