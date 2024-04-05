import java.util.*;

// https://www.luogu.com.cn/problem/P7557
public class HIndex {
    static int N, K, L;
    static int[] citations;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt(); // 论文数量
        K = scanner.nextInt(); // 综述数量
        L = scanner.nextInt(); // 最多引用论文数量
        citations = new int[N];
        for (int i = 0; i < N; i++) {
            citations[i] = scanner.nextInt();
        }
        Arrays.sort(citations);

        // 二分答案
        int l = 0, r = N;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid))
                l = mid;
            else
                r = mid - 1;
        }
        System.out.println(r);
        scanner.close();
    }

    private static boolean check(int H) {
        int count = 0;
        for (int i = N - 1; i >= N - H; i--) {
            if (citations[i] < H - K) {
                return false;
            } else if (citations[i] < H) {
                count += H - citations[i];
            }
        }
        return count <= K * L;
    }
}
