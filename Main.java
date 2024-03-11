import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        int n = scan.nextInt();

        int[] x = new int[k];
        int[] y = new int[k];
        for (int i = 0; i < k; i++) {
            x[i] = scan.nextInt();
            y[i] = scan.nextInt();
        }

        int totalPower = 0;
        boolean[] beat = new boolean[k];
        while (n-- > 0) {
            int min = 0x3f3f3f3f;
            int minIndex = -1;
            for (int i = 0; i < k - 1; i++) {
                if (beat[i]) {
                    if (min > y[i]) {
                        min = y[i];
                        minIndex = i;
                    }
                } else {
                    if (min >= x[i]) {
                        min = x[i];
                        minIndex = i;
                    }
                }
            }

            boolean flag = true;
            for (int i = 0; i < k - 1; i++) {
                if (!beat[i]) {
                    flag = false;
                }
            }
            if (flag) {
                if (beat[k - 1]) {
                    if (min > y[k - 1]) {
                        min = y[k - 1];
                        minIndex = k - 1;
                    }
                } else {
                    if (min >= x[k - 1]) {
                        min = x[k - 1];
                        minIndex = k - 1;
                    }
                }
            }
            totalPower += min;
            beat[minIndex] = true;
        }
        System.out.println(totalPower);

        scan.close();
    }
}