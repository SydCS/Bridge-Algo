import java.util.Arrays;
import java.util.Scanner;

public class HorseRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n == 0)
                break;

            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt(); // Reading array a
            }

            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt(); // Reading array b
            }

            Arrays.sort(a); // Sorting array a
            Arrays.sort(b); // Sorting array b

            int pafast = n - 1, pbfast = n - 1;
            int paslow = 0, pbslow = 0;
            int ans = 0;

            for (int i = 0; i < n; i++) {
                if (a[paslow] > b[pbslow]) { // If current slowest in a is faster than slowest in b
                    paslow++;
                    pbslow++;
                    ans++;
                } else if (a[paslow] < b[pbslow]) { // If current slowest in a is slower than slowest in b, compare with
                                                    // fastest in b
                    paslow++;
                    pbfast--;
                    ans--;
                } else { // If current slowest in a is equal to slowest in b
                    if (a[pafast] > b[pbfast]) { // If current fastest in a is faster than fastest in b
                        pafast--;
                        pbfast--;
                        ans++;
                    } else if (a[paslow] < b[pbfast]) { // If current slowest in a is slower than fastest in b, compare
                                                        // with fastest in b
                        paslow++;
                        pbfast--;
                        ans--;
                    }
                }
            }

            System.out.println(ans * 200);
        }
        scanner.close();
    }
}