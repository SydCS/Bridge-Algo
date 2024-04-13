import java.util.Arrays;

public class CompleteKnapsack {
    public static void main(String[] args) {
        int[] weights = { 5, 4 }; // 物品的重量
        int[] values = { 1, 2 }; // 物品的价值
        int capacity = 10; // 背包的容量

        System.out.println("最大价值为: " + knapsack(weights, values, capacity));
    }

    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[] dp = new int[capacity + 1];

        // 初始化，除了dp[0]为0（表示容量为0时的最大价值为0）外，其余都初始化为一个很小的值，
        // 这样做是为了确保只有在背包确实可以被完全填满时才会更新这些值。
        for (int i = 1; i <= capacity; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        // 遍历每一个物品
        for (int i = 0; i < n; i++) {
            // 遍历所有的容量，由于是完全背包，所以正向遍历
            for (int j = weights[i]; j <= capacity; j++) {
                if (dp[j - weights[i]] != Integer.MIN_VALUE) {
                    dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        // 如果dp[capacity]为初始值，说明背包无法被完全填满
        return dp[capacity] != Integer.MIN_VALUE ? dp[capacity] : -1;
    }
}
