import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();

            if (n % 3 == 0)
                System.out.println("Cici");
            else
                System.out.println("Kiki");
        }
        sc.close();
    }
}
