import java.io.*;

// https://www.acwing.com/problem/content/1267/
public class CountingStars {
    // IO 代码
    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in), 32768));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    static int[] tree = new int[32010]; // 树状数组

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int[] level = new int[N];

        // 操作：
        // 1. 求 <= x 的数的个数
        // 2. 添加一个数 x

        while (N-- > 0) {
            int x = nextInt() + 1, y = nextInt(); // 从 1 开始
            level[query(x)]++;
            add(x, 1);
        }

        for (int l : level) {
            out.println(l);
        }
        out.close();
    }

    private static int lowbit(int x) {
        // 最低位 1 与后面的 0 组成的数
        return x & (-x);
    }

    private static void add(int x, int val) {
        // x 处 + val
        while (x <= tree.length) {
            tree[x] += val;
            x += lowbit(x);
        }
    }

    private static int query(int x) {
        // 前 x 个数的和
        // if (x == 0)
        // return 0;

        // return tree[x] + query(x - lowbit(x));

        int result = 0;
        while (x >= 1) {
            result += tree[x];
            x -= lowbit(x);
        }
        return result;
    }
}
