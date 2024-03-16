import java.util.*;

public class Permutations {
    static int n;
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        nums = new int[n + 1];
        visited = new boolean[n + 1];

        dfs(1);

        scanner.close();
    }

    public static void dfs(int step) { // step: 接下来准备处理第 step 位
        if (step == n + 1) {
            for (int i = 1; i <= n; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                nums[step] = i;
                visited[i] = true;

                dfs(step + 1);

                visited[i] = false; // 回溯
            }
        }
    }
}

class Permutations2 {
    static int n;
    static List<Integer> nums;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        nums = new ArrayList<>();
        visited = new boolean[n + 1];

        dfs();

        scanner.close();
    }

    public static void dfs() {
        if (nums.size() == n) {
            for (int i : nums) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                nums.add(i);

                dfs();

                nums.remove(nums.size() - 1);
                visited[i] = false;
            }
        }
    }
}