import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class DegreeSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            Integer[] a = new Integer[1010];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                sum += a[i];
            }

            if (sum % 2 != 0) { // 可图化
                System.out.println("no");
                continue;
            } else { // 可简单图化
                Arrays.sort(a, 0, n, Collections.reverseOrder()); // 降序
                // Arrays.sort(a, (o1, o2) -> o2.compareTo(o1));
                int flag = 0;
                for (int i = 0; i < n - 1; i++) {
                    flag = 0;
                    for (int j = 0; j < a[i] && j < n; j++) {
                        a[i + j + 1] -= 1;
                        if (a[i + j + 1] < 0) {
                            System.out.println("no");
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 1)
                        break;
                    Arrays.sort(a, i + 1, n, Collections.reverseOrder());
                }
                if (a[n - 1] == 0 && flag == 0)
                    System.out.println("yes");
            }
        }
        scanner.close();
    }
}