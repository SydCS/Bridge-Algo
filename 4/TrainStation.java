import java.util.Scanner;
import java.util.Stack;
import java.math.BigInteger;

public class TrainStation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String orderIn = scanner.next();
            String orderOut = scanner.next();

            if (canExchange(orderIn, orderOut)) {
                System.out.println("Yes.");
                exchangeOrder(orderIn, orderOut);
            } else {
                System.out.println("No.");
            }
            System.out.println("FINISH");
        }

        scanner.close();
    }

    private static boolean canExchange(String orderIn, String orderOut) {
        Stack<Character> stack = new Stack<>();
        int j = 0;

        for (int i = 0; i < orderIn.length(); i++) {
            stack.push(orderIn.charAt(i));

            while (!stack.isEmpty() && stack.peek() == orderOut.charAt(j)) {
                stack.pop();
                j++;

                if (j == orderOut.length()) {
                    return true;
                }
            }
        }
        return stack.isEmpty();
    }

    private static void exchangeOrder(String orderIn, String orderOut) {
        Stack<Character> stack = new Stack<>();
        int j = 0;

        for (int i = 0; i < orderIn.length(); i++) {
            stack.push(orderIn.charAt(i));
            System.out.println("in");

            while (!stack.isEmpty() && stack.peek() == orderOut.charAt(j)) {
                stack.pop();
                System.out.println("out");
                j++;
            }
        }
    }
}

class TrainProblemII {
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
