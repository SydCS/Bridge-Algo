import java.util.Scanner;

// https://www.acwing.com/problem/content/169/
public class Stick {
    static int[] sticks;
    static boolean[] visited;
    static int sum;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            if (n == 0)
                break;

            sticks = new int[n];
            sum = 0;
            int max = 0xc0c0c0c0;
            for (int i = 0; i < n; i++) {
                sticks[i] = scanner.nextInt();
                sum += sticks[i];
                max = Math.max(max, sticks[i]);
            }

            // 从小到大枚举初始长度
            visited = new boolean[n];
            for (int len = max; len <= sum; len++) {
                if (sum % len == 0) {
                    if (dfs(0, 0, 0, len)) {
                        System.out.println(len);
                        break;
                    }
                }
            }
        }
        scanner.close();
    }

    /**
     * A method to perform depth-first search.
     *
     * @param count 当前拼了几根原始木棍
     * @param l     当前正在拼的原始木棍长度
     * @param index 当前枚举到第几个小木棍
     * @param len   初始长度
     * @return 是否可能
     */
    private static boolean dfs(int count, int l, int index, int len) {
        if (count * len == sum)
            return true;

        if (l == len)
            return dfs(count + 1, 0, 0, len);

        for (int i = index; i < sticks.length; i++) {
            if (!visited[i] && l + sticks[i] <= len) {
                visited[i] = true;
                if (dfs(count, l + sticks[i], i + 1, len))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
