import java.util.Scanner;

public class Pie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n == 0)
                break;

            int maxTime = Integer.MIN_VALUE;
            int[][] pie = new int[100010][11];

            for (int i = 0; i < n; i++) {
                int s = scanner.nextInt();
                int t = scanner.nextInt();
                pie[t][s]++;
                maxTime = Math.max(maxTime, t);
            }

            for (int i = maxTime - 1; i >= 0; i--) {
                for (int j = 0; j <= 10; j++) {
                    pie[i][j] += Math.max(pie[i + 1][j],
                            Math.max(pie[i + 1][Math.min(j + 1, 10)], pie[i + 1][Math.max(0, j - 1)]));
                }
            }
            System.out.println(pie[0][5]);
        }
        scanner.close();
    }
}
