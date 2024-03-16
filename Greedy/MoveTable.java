import java.util.Scanner;

// https://acm.hdu.edu.cn/showproblem.php?pid=1050
public class MoveTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int[] P = new int[200];
            int N = scanner.nextInt(); // Number of tables to move
            for (int j = 0; j < N; j++) {
                int s = scanner.nextInt();
                int d = scanner.nextInt();
                s = (s - 1) / 2;
                d = (d - 1) / 2;

                if (s > d) {
                    int temp = s;
                    s = d;
                    d = temp;
                }

                for (int k = s; k <= d; k++) {
                    P[k]++;
                }
            }

            int overlap = -1;
            for (int j = 0; j < 200; j++) {
                overlap = Math.max(overlap, P[j]);
            }
            System.out.println(overlap * 10);
        }

        scanner.close();
    }
}
