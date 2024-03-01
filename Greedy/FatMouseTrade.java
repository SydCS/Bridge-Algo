import java.util.*;

public class FatMouseTrade {
    static class Room implements Comparable<Room> {
        double beans;
        double food;
        double ratio;

        public Room(double beans, double food) {
            this.beans = beans;
            this.food = food;
            this.ratio = beans / food;
        }

        @Override
        public int compareTo(Room other) {
            return Double.compare(other.ratio, this.ratio); // 降序
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            double M = scanner.nextDouble();
            int N = scanner.nextInt();
            if (M == -1 && N == -1)
                break;

            List<Room> rooms = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                double J = scanner.nextDouble();
                double F = scanner.nextDouble();
                rooms.add(new Room(J, F));
            }

            Collections.sort(rooms);

            double result = 0;
            for (Room room : rooms) {
                if (M >= room.food) {
                    result += room.beans;
                    M -= room.food;
                } else {
                    result += M * room.ratio;
                    break;
                }
            }

            System.out.printf("%.3f\n", result);
        }
        scanner.close();
    }
}