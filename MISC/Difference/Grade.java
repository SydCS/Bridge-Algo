import java.io.*;

// https://www.luogu.com.cn/problem/P2367
public class Grade {
    // IO 代码
    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in), 32768));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt(), p = nextInt();

        int[] nums = new int[n + 1];
        int[] diff = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            nums[i] = nextInt();
            diff[i] = nums[i] - nums[i - 1];
        }

        while (p-- > 0) {
            int x = nextInt(), y = nextInt(), z = nextInt();
            diff[x] += z;
            diff[y + 1] -= z;
        }

        int min = 0x3f3f3f3f;
        for (int i = 1; i <= n; i++) {
            nums[i] = nums[i - 1] + diff[i];
            min = Math.min(min, nums[i]);
        }
        out.println(min);
        out.close();
    }
}