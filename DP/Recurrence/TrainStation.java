import java.util.Scanner;
import java.math.BigInteger;

// https://acm.hdu.edu.cn/showproblem.php?pid=1023
class TrainStaion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            System.out.println(catalanNumber(n));
        }
        scanner.close();
    }

    // 计算第 n 个卡特兰数
    private static BigInteger catalanNumber(int n) {
        BigInteger result = factorial(2 * n).divide(factorial(n + 1).multiply(factorial(n)));
        return result;
    }

    // 计算阶乘
    private static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
