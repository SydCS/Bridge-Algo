import java.io.*;

// https://www.acwing.com/problem/content/description/5399/
public class Board {
    // IO 代码
    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in), 32768));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();

        // 纪录每个位置的操作次数

        // 二维差分
        int[][] diff = new int[n + 2][n + 2];
        while (m-- > 0) {
            int x1 = nextInt(), y1 = nextInt(), x2 = nextInt(), y2 = nextInt();
            diff[x1][y1]++;
            diff[x1][y2 + 1]--;
            diff[x2 + 1][y1]--;
            diff[x2 + 1][y2 + 1]++;
        }

        // 每个位置的前缀和
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                diff[i][j] += diff[i][j - 1] + diff[i - 1][j] - diff[i - 1][j - 1];
                out.print(diff[i][j] % 2);
            }
            out.println();
        }
        out.flush();
    }
}
