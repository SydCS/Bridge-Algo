import java.util.Scanner;

// https://www.acwing.com/problem/content/4971/
public class Coprime {
    static final long MOD = 998244353;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong(), b = sc.nextLong();
        sc.close();

        if (a == 1) {
            System.out.println(0);
            return;
        }

        // 求 a^b 的欧拉函数
        long totient = a, tmp = a;
        // 对 a 分解质因数
        for (int i = 2; i <= tmp / i; i++) {
            if (tmp % i == 0) {
                totient = totient / i * (i - 1);
                while (tmp % i == 0) {
                    tmp /= i;
                }
            }
        }
        if (tmp > 1) {
            totient = totient / tmp * (tmp - 1);
        }

        System.out.println(fastExpoMod(a, b - 1, MOD) * totient % MOD);
    }

    private static long fastExpoMod(long a, long b, long MOD) {
        long result = 1 % MOD;
        a %= MOD;

        while (b >= 1) {
            if (b % 2 == 1) {
                result = result * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }

        return result;
    }
}