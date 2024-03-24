import java.util.Scanner;

// https://www.luogu.com.cn/problem/P8647
public class Chocolate {
    static int N, K;
    static int[] H, W;
    static int maxSide = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        H = new int[N];
        W = new int[N];
        for (int i = 0; i < N; i++) {
            int h = sc.nextInt(), w = sc.nextInt();
            maxSide = Math.max(maxSide, Math.max(h, w));
            H[i] = h;
            W[i] = w;
        }

        System.out.println(binarySearch());
        sc.close();
    }

    private static int binarySearch() {
        int left = 0, right = maxSide;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (check(mid))
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }

    private static boolean check(int mid) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            count += (H[i] / mid) * (W[i] / mid);
        }
        return count >= K;
    }
}
