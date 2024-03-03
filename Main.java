import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            ArrayList<Integer> numbers = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                numbers.add(i);
            }

            StringBuilder result = new StringBuilder();
            m--; // 由于我们是从0开始计数的，所以先减1
            int factorial = 1;
            for (int i = 2; i < n; i++) {
                factorial *= i;
            }

            int index;
            for (int i = n - 1; i >= 0; i--) {
                index = m / factorial;
                m = m % factorial;
                if (i != 0) {
                    factorial /= i;
                }
                result.append(numbers.remove(index)).append(" ");
            }

            System.out.println(result.toString());
        }
        scanner.close();
    }
}
