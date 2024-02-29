import java.util.Scanner;

public class FibonacciMod3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // // 预先计算出前两个值的模3结果，用于后续计算
        // int a = 7 % 3; // F(0) % 3
        // int b = 11 % 3; // F(1) % 3

        while (scanner.hasNextInt()) {
            // 1 2 0 2 2 1 0 1
            switch (scanner.nextInt() % 8) {
                case 2, 6:
                    System.out.println("yes");
                    break;
                default:
                    System.out.println("no");
                    break;
            }

            // int n = scanner.nextInt();

            // // 特殊处理前两个数
            // if (n == 0) {
            // System.out.println(a == 0 ? "yes" : "no");
            // continue;
            // } else if (n == 1) {
            // System.out.println(b == 0 ? "yes" : "no");
            // continue;
            // }

            // int c = 0; // 用于存储当前F(n)模3的结果
            // // 从2开始迭代，直到n
            // for (int i = 2; i <= n; i++) {
            // // 计算F(n)模3的结果，仅依赖于F(n-1)和F(n-2)模3的结果
            // c = (a + b) % 3;
            // // 更新F(n-2)和F(n-1)的值
            // a = b;
            // b = c;
            // }

            // // 如果c等于0，则F(n)可以被3整除
            // System.out.println(c == 0 ? "yes" : "no");
        }

        scanner.close();
    }
}
