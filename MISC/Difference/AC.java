import java.util.*;

// https://www.luogu.com.cn/problem/P7994
public class AC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] p = new int[N];
        int[] t = new int[N];
        int[] gap = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            t[i] = scanner.nextInt();
            gap[i] = p[i] - t[i];
        }

        int[] diff = new int[N];
        diff[0] = gap[0];
        for (int i = 1; i < N; i++) {
            diff[i] = gap[i] - gap[i - 1];
        }

        int pos = 0, neg = 0;
        for (int i : diff) {
            if (i > 0)
                pos += i;
            else
                neg -= i;
        }
        System.out.println(Math.max(pos, neg));
        scanner.close();
    }
}