import java.util.*;

// https://acm.hdu.edu.cn/showproblem.php?pid=1495
public class Cola {
    static int S, N, M;

    static class State {
        int s, n, m;
        int steps;

        public State(int s, int n, int m, int steps) {
            this.s = s;
            this.n = n;
            this.m = m;
            this.steps = steps;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            S = scanner.nextInt();
            N = scanner.nextInt();
            M = scanner.nextInt();
            if (S == 0 && N == 0 && M == 0)
                break;

            int steps = bfs(new State(S, 0, 0, 0));
            System.out.println(steps == -1 ? "NO" : steps);
        }
        scanner.close();
    }

    private static int bfs(State s) {
        Queue<State> queue = new LinkedList<State>();
        queue.add(s);
        boolean[][] visited = new boolean[s.s + 1][s.s + 1];
        visited[s.n][s.m] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();
            if ((cur.s == cur.m && cur.n == 0) || (cur.s == cur.n && cur.m == 0)
                    || (cur.m == cur.n && cur.s == 0))
                return cur.steps;

            // 模拟倒水
            State next;

            if (cur.s >= N - cur.n) {
                next = new State(cur.s - (N - cur.n), N, cur.m, cur.steps + 1);
            } else {
                next = new State(0, cur.n + cur.s, cur.m, cur.steps + 1);
            }
            if (!visited[next.n][next.m]) {
                visited[next.n][next.m] = true;
                queue.add(next);
            }

            if (cur.m >= N - cur.n) {
                next = new State(cur.s, N, cur.m - (N - cur.n), cur.steps + 1);
            } else {
                next = new State(cur.s, cur.n + cur.m, 0, cur.steps + 1);
            }
            if (!visited[next.n][next.m]) {
                visited[next.n][next.m] = true;
                queue.add(next);
            }

            if (cur.n >= S - cur.s) {
                next = new State(S, cur.n - (S - cur.s), cur.m, cur.steps + 1);
            } else {
                next = new State(cur.s + cur.n, 0, cur.m, cur.steps + 1);
            }
            if (!visited[next.n][next.m]) {
                visited[next.n][next.m] = true;
                queue.add(next);
            }

            if (cur.m >= S - cur.s) {
                next = new State(S, cur.n, cur.m - (S - cur.s), cur.steps + 1);
            } else {
                next = new State(cur.s + cur.m, cur.n, 0, cur.steps + 1);
            }
            if (!visited[next.n][next.m]) {
                visited[next.n][next.m] = true;
                queue.add(next);
            }

            if (cur.n >= M - cur.m) {
                next = new State(cur.s, cur.n - (M - cur.m), M, cur.steps + 1);
            } else {
                next = new State(cur.s, 0, cur.m + cur.n, cur.steps + 1);
            }
            if (!visited[next.n][next.m]) {
                visited[next.n][next.m] = true;
                queue.add(next);
            }

            if (cur.s >= M - cur.m) {
                next = new State(cur.s - (M - cur.m), cur.n, M, cur.steps + 1);
            } else {
                next = new State(0, cur.n, cur.m + cur.s, cur.steps + 1);
            }
            if (!visited[next.n][next.m]) {
                visited[next.n][next.m] = true;
                queue.add(next);
            }
        }
        return -1;
    }
}
