import java.util.*;

public class Melon {
    static int[] melons;
    static int m;
    static int[] suffix; // 后缀和，剪枝用
    static int ans = 0x3f3f3f3f;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        m = scanner.nextInt();
        melons = new int[n];
        for (int i = 0; i < n; i++) {
            melons[i] = scanner.nextInt();
        }
        Arrays.sort(melons);
        for (int min = 0, max = melons.length - 1; min < max; min++, max--) { // 逆序
            int temp = melons[min];
            melons[min] = melons[max];
            melons[max] = temp;
        }

        suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + melons[i];
        }

        dfs(0, 0, 0);
        System.out.println(ans == 0x3f3f3f3f ? -1 : ans);
        scanner.close();
    }

    private static void dfs(int index, double weight, int cut) {
        if (weight == m) {
            ans = Math.min(ans, cut);
            return;
        }

        if (index == melons.length)
            return;

        if (weight > m) // 重量超了，剪枝
            return;

        if (cut >= ans) // 次数超了，剪枝
            return;

        if (weight + suffix[index] < m) // 如果后面所有瓜的重量加起来都小于m，剪枝
            return;

        dfs(index + 1, weight, cut);
        dfs(index + 1, weight + melons[index], cut);
        dfs(index + 1, weight + melons[index] / 2.0, cut + 1);
    }
}
