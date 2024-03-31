import java.util.*;

// https://www.luogu.com.cn/problem/P1215
public class Milk {
    static class State {
        int a, b, c;

        public State(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static int a, b, c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();

        List<Integer> possible = bfs(new State(0, 0, c));
        Collections.sort(possible);
        for (int i : possible) {
            System.out.print(i + " ");
        }
        scanner.close();
    }

    private static List<Integer> bfs(State state) {
        Queue<State> queue = new LinkedList<>();
        queue.add(state);
        boolean[][] visited = new boolean[21][21];
        visited[state.b][state.c] = true;

        List<Integer> possible = new ArrayList<>();
        while (!queue.isEmpty()) {
            State cur = queue.poll();
            if (cur.a == 0) {
                possible.add(cur.c);
            }

            // 模拟倒水
            State next;

            if (cur.a >= b - cur.b) {
                next = new State(cur.a - (b - cur.b), b, cur.c);
            } else {
                next = new State(0, cur.b + cur.a, cur.c);
            }
            if (!visited[next.b][next.c]) {
                visited[next.b][next.c] = true;
                queue.add(next);
            }

            if (cur.c >= b - cur.b) {
                next = new State(cur.a, b, cur.c - (b - cur.b));
            } else {
                next = new State(cur.a, cur.b + cur.c, 0);
            }
            if (!visited[next.b][next.c]) {
                visited[next.b][next.c] = true;
                queue.add(next);
            }

            if (cur.b >= a - cur.a) {
                next = new State(a, cur.b - (a - cur.a), cur.c);
            } else {
                next = new State(cur.a + cur.b, 0, cur.c);
            }
            if (!visited[next.b][next.c]) {
                visited[next.b][next.c] = true;
                queue.add(next);
            }

            if (cur.c >= a - cur.a) {
                next = new State(a, cur.b, cur.c - (a - cur.a));
            } else {
                next = new State(cur.a + cur.c, cur.b, 0);
            }
            if (!visited[next.b][next.c]) {
                visited[next.b][next.c] = true;
                queue.add(next);
            }

            if (cur.b >= c - cur.c) {
                next = new State(cur.a, cur.b - (c - cur.c), c);
            } else {
                next = new State(cur.a, 0, cur.c + cur.b);
            }
            if (!visited[next.b][next.c]) {
                visited[next.b][next.c] = true;
                queue.add(next);
            }

            if (cur.a >= c - cur.c) {
                next = new State(cur.a - (c - cur.c), cur.b, c);
            } else {
                next = new State(0, cur.b, cur.c + cur.a);
            }
            if (!visited[next.b][next.c]) {
                visited[next.b][next.c] = true;
                queue.add(next);
            }
        }
        return possible;
    }
}
