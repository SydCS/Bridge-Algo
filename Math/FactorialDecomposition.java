import java.util.Arrays;
import java.util.Scanner;

// https://www.acwing.com/problem/content/199/
public class FactorialDecomposition {
    static int[] primes;
    static int count;
    static boolean[] isPrime;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        getPrimes(N);

        // 1 ~ N 中有多少个质数 p p^2 ... 的倍数
        for (int i = 0; i < count; i++) {
            int p = primes[i];
            int alpha = 0, tmp = N;
            while (tmp != 0) {
                alpha += tmp / p;
                tmp /= p;
            }
            System.out.println(p + " " + alpha);
        }
    }

    private static void getPrimes(int N) {
        // 欧拉筛：每个合数只被筛掉一次，被它的最小质因子筛掉
        primes = new int[N + 1];
        isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i <= N; i++) {
            if (isPrime[i])
                primes[count++] = i;

            // 每个数，乘上 <= 其最小质因子的质数
            for (int j = 0; j < count && i * primes[j] <= N; j++) {
                isPrime[i * primes[j]] = false;
                if (i % primes[j] == 0)
                    break;
            }
        }
    }
}
