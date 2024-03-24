import java.io.*;

// https://www.luogu.com.cn/problem/P2249
public class FirstOccurrence {
    // IO 代码
    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in), 32768));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt(); // 数字的个数
        int m = nextInt(); // 查询次数
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = nextInt();
        }

        while (m-- > 0) {
            findFirstOccurrence(nums, nextInt()); // 输出第一次出现的位置；如果未找到，则输出-1
        }
    }

    // 二分查找第一次出现的位置
    private static void findFirstOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (right == nums.length || nums[right] != target) {
            System.out.print(-1 + " ");
        } else {
            System.out.print(right + 1 + " ");
        }
    }
}
