import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// https://www.luogu.com.cn/problem/P1886 单调队列模板
public class MonoQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] max = new int[n - k + 1];
        int[] min = new int[n - k + 1];
        Deque<Integer> q1 = new ArrayDeque<>(); // 递减
        Deque<Integer> q2 = new ArrayDeque<>(); // 递增
        for (int i = 0; i < n; i++) {
            // 入
            while (!q1.isEmpty() && nums[i] >= nums[q1.peekLast()]) {
                q1.pollLast();
            }
            q1.addLast(i);

            while (!q2.isEmpty() && nums[i] <= nums[q2.peekLast()]) {
                q2.pollLast();
            }
            q2.addLast(i);

            // 出窗口了
            if (i - q1.peekFirst() >= k) {
                q1.pollFirst();
            }

            if (i - q2.peekFirst() >= k) {
                q2.pollFirst();
            }

            // 记录答案
            if (i >= k - 1) {
                max[i - k + 1] = nums[q1.peekFirst()];
                min[i - k + 1] = nums[q2.peekFirst()];
            }
        }

        for (int i : min) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : max) {
            System.out.print(i + " ");
        }
        scanner.close();
    }
}
