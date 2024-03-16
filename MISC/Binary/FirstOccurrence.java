import java.util.Scanner;

// https://www.luogu.com.cn/problem/P2249
public class FirstOccurrence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 数字的个数
        int m = scanner.nextInt(); // 查询次数
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = scanner.nextInt();
        }

        while (m-- > 0) {
            findFirstOccurrence(nums, scanner.nextInt()); // 输出第一次出现的位置，如果未找到，则输出-1
        }
        scanner.close();
    }

    // 二分查找第一次出现的位置
    private static void findFirstOccurrence(int[] nums, int target) {
        int left = 1, right = nums.length;

        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == nums.length || nums[left] != target) {
            System.out.print(-1 + " ");
        } else {
            System.out.print(left + " ");
        }
    }
}
