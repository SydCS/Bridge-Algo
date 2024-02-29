import java.util.Scanner;

public class DeleteNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        int s = scanner.nextInt();

        while (s > 0) {
            int i = 0;
            for (; i < n.length() - 1 && n.charAt(i) <= n.charAt(i + 1); i++) {
                // Loop to find the peak
            }
            // Delete character at the peak
            n = n.substring(0, i) + n.substring(i + 1);
            s--;
        }

        // Remove leading zeros, but leave at least one digit
        while (n.startsWith("0") && n.length() > 1) {
            n = n.substring(1);
        }

        System.out.println(n);
        scanner.close();
    }
}
