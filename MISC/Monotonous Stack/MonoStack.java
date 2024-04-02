import java.util.Scanner;
import java.util.Stack;

// https://www.luogu.com.cn/problem/P5788 单调栈模板
public class MonoStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] next = new int[n + 1]; // NGE
        Stack<Integer> stack = new Stack<>(); // 存放下标
        for (int i = n; i >= 1; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(i);
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(next[i] + " ");
        }
        scanner.close();
    }
}
