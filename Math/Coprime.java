import java.util.Scanner;

// https://www.acwing.com/problem/content/4971/
public class Coprime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt(), b = sc.nextLong();
        long mod = 998244353;

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

        System.out.println(fastExpoMod(a, b - 1, mod) * totient % mod);
    }

    private static long fastExpoMod(long a, long b, long mod) {
        long result = 1 % mod;
        a %= mod;

        while (b >= 1) {
            if (b % 2 == 1) {
                result = result * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }

        return result;
    }
}