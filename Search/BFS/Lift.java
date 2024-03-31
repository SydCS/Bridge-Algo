import java.util.*;

// https://acm.hdu.edu.cn/showproblem.php?pid=1548
public class Lift {
    static class Floor {
        int position;
        int steps;

        public Floor(int position, int steps) {
            this.position = position;
            this.steps = steps;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int N = scanner.nextInt();
            if (N == 0)
                break; // End of input

            int begin = scanner.nextInt() - 1; // Zero indexing
            int end = scanner.nextInt() - 1; // Zero indexing

            int[] K = new int[N];
            for (int i = 0; i < N; i++) {
                K[i] = scanner.nextInt();
            }

            System.out.println(bfs(N, begin, end, K));
        }
        scanner.close();
    }

    private static int bfs(int N, int begin, int end, int[] K) {
        Queue<Floor> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        queue.add(new Floor(begin, 0));
        visited[begin] = true;

        while (!queue.isEmpty()) {
            Floor current = queue.poll();
            if (current.position == end) {
                return current.steps;
            }

            int up = current.position + K[current.position];
            int down = current.position - K[current.position];

            if (up < N && !visited[up]) {
                visited[up] = true;
                queue.add(new Floor(up, current.steps + 1));
            }

            if (down >= 0 && !visited[down]) {
                visited[down] = true;
                queue.add(new Floor(down, current.steps + 1));
            }
        }

        return -1; // Not reachable
    }
}
