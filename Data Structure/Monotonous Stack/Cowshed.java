import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// https://www.acwing.com/problem/content/description/1415/
public class Cowshed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int R = scanner.nextInt(), C = scanner.nextInt(), P = scanner.nextInt();
        boolean[][] bomb = new boolean[R][C + 1];
        while (P-- > 0) {
            bomb[scanner.nextInt() - 1][scanner.nextInt() - 1] = true;
        }

        // 高度预处理
        int[][] heights = new int[R][C + 1]; // 在 R 列从 C 及往上最多有多少个未被破坏的矩形
        for (int i = 0; i < R; i++) {
            for (int j = C - 1; j >= 0; j--) {
                if (!bomb[i][j])
                    heights[i][j] = heights[i][j + 1] + 1;
            }
        }

        int maxArea = 0;
        for (int low = 0; low < C; low++) { // 枚举下边界
            // 直方图中最大矩形 O(R)

            // 单调栈预处理：左/右边第一个比 heights[i] 小的下标
            int[] left = new int[R];
            int[] right = new int[R];

            Deque<Integer> stack = new ArrayDeque<>(); // 存放下标
            for (int i = 0; i < R; i++) { // 从左往右
                while (!stack.isEmpty() && heights[i][low] <= heights[stack.peek()][low]) {
                    stack.pop();
                }
                left[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            stack.clear();
            for (int i = R - 1; i >= 0; i--) { // 从右往左
                while (!stack.isEmpty() && heights[i][low] <= heights[stack.peek()][low]) {
                    stack.pop();
                }
                right[i] = stack.isEmpty() ? R : stack.peek();
                stack.push(i);
            }

            for (int i = 0; i < R; i++) {
                maxArea = Math.max(maxArea, heights[i][low] * (right[i] - left[i] - 1));
            }
        }
        System.out.println(maxArea);
        scanner.close();
    }
}
