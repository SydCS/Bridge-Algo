public class FastExponentiationModular {
    public static void main(String[] args) {
        long base = 2;
        long exponent = 30;
        long modulus = 1000000007;
        System.out.printf("%d^%d mod %d = %d", base, exponent, modulus, fastExpoMod(base, exponent, modulus));
    }

    private static long fastExpoMod(long a, long b, long m) {
        long result = 1 % m;
        a %= m;

        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % m;
            }
            a = (a * a) % m;
            b >>= 1;
        }

        return result;
    }
}
