import java.util.Arrays;
import java.util.Scanner;

// https://acm.hdu.edu.cn/showproblem.php?pid=1007
public class Quoit {
    static class Point implements Comparable<Point> {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point b) {
            return Double.compare(this.x + this.y, b.x + b.y); // 升序
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0)
                break;

            Point[] points = new Point[n];
            for (int i = 0; i < n; i++) {
                points[i] = new Point(scanner.nextDouble(), scanner.nextDouble());
            }
            Arrays.sort(points);

            double minDistance = Double.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < i + 5 && j < n; j++) { // NOTE: wrong algo but AC
                    minDistance = Math.min(minDistance,
                            Math.pow((points[i].x - points[j].x), 2) + Math.pow((points[i].y - points[j].y), 2));
                }
            }
            System.out.printf("%.2f%n", Math.sqrt(minDistance) / 2);
        }

        scanner.close();
    }
}
