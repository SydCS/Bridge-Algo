import java.util.Scanner;

// https://www.luogu.com.cn/problem/P8710
public class NetworkNode {
    static int[] parents;

    static int find(int x) {
        return parents[x] == x ? x : (parents[x] = find(parents[x]));
    }

    static void union(int x, int y) {
        parents[find(x)] = find(y);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        parents = new int[n + 1];
        int[] msg = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        // O(m n logn)
        while (m-- > 0) {
            int op = scanner.nextInt();
            if (op == 1) {
                union(scanner.nextInt(), scanner.nextInt());
            } else if (op == 2) {
                int p = scanner.nextInt(), t = scanner.nextInt();
                int pRoot = find(p);
                for (int i = 1; i <= n; i++) {
                    if (find(i) == pRoot) {
                        msg[i] += t;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(msg[i] + " ");
        }
        scanner.close();
    }
}
