import java.util.Scanner;

public class Divisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            int a = scanner.nextInt();
            // O(\sqrt a)

            // 法1：试除法
            // int count = 0;
            // for (int i = 1; i <= a / i; i++) {
            // if (a % i == 0) {
            // count += 1;
            // if (i != a / i) {
            // count += 1;
            // }
            // }
            // }

            // 法2：分解质因数
            int count = 1;
            for (int i = 2; i <= a / i; i++) {
                if (a % i == 0) {
                    int alpha = 0;
                    while (a % i == 0) {
                        a /= i;
                        alpha++;
                    }
                    count *= (alpha + 1);
                }
            }
            if (a > 1) {
                count *= 2;
            }

            System.out.println(count);
        }
        scanner.close();
    }
}
