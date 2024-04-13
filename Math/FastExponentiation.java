public class FastExponentiation {
    public static void main(String[] args) {
        int base = 2;
        int exponent = 30;
        System.out.println(base + "^" + exponent + " = " + fastExpoRecur(base, exponent));
    }

    private static long fastExpo(long base, int exponent) {
        long result = 1;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result *= base;
            }
            base *= base;
            exponent >>= 1;
        }

        return result;
    }

    private static long fastExpoRecur(long base, int exponent) {
        if (exponent == 0)
            return 1;

        long result = fastExpoRecur(base * base, exponent / 2);

        if (exponent % 2 == 1)
            result *= base;

        return result;
    }
}
