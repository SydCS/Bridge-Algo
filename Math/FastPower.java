public class FastPower {
    public static void main(String[] args) {
        int base = 2;
        int exponent = 10;
        long result = fastPowerRecur(base, exponent);
        System.out.println(base + "^" + exponent + " = " + result);
    }

    private static long fastPower(long base, int exponent) {
        long result = 1;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result *= base;
            }
            base *= base;
            exponent /= 2;
        }

        return result;
    }

    private static long fastPowerRecur(long base, int exponent) {
        if (exponent == 0)
            return 1;

        long result = fastPowerRecur(base * base, exponent / 2);

        if (exponent % 2 == 1)
            result *= base;

        return result;
    }
}

class FastPowerModular {
    public static void main(String[] args) {
        int base = 2;
        int exponent = 10;
        int modulus = 1000000007; // A common modulus used in competitive programming
        long result = fastPowerModular(base, exponent, modulus);
        System.out.println(base + "^" + exponent + " mod " + modulus + " = " + result);
    }

    private static long fastPowerModular(int base, int exponent, int modulus) {
        base %= modulus;
        long result = 1;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % modulus;
            }
            base = (int) ((long) base * base % modulus);
            exponent /= 2;
        }

        return result;
    }
}
