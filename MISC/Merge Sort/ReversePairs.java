import java.io.*;

// https://www.luogu.com.cn/problem/P1908 逆序对模板
public class ReversePairs {
    // IO 代码
    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in), 32768));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    static long reverse = 0;

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = nextInt();
        }

        mergeSort(num, 0, n - 1);
        System.out.println(reverse);
    }

    private static void mergeSort(int[] num, int l, int r) {
        if (l >= r)
            return;

        int mid = (l + r) >> 1;
        mergeSort(num, l, mid);
        mergeSort(num, mid + 1, r);
        if (num[mid] > num[mid + 1])
            merge(num, l, mid, r);
    }

    private static void merge(int[] num, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (num[i] <= num[j]) {
                tmp[k++] = num[i++];
            } else {
                reverse += (mid - i + 1); // 产生逆序对：左区间所有num[i]及之后的数都比num[j]大
                tmp[k++] = num[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = num[i++];
        }
        while (j <= r) {
            tmp[k++] = num[j++];
        }
        System.arraycopy(tmp, 0, num, l, tmp.length);
    }
}