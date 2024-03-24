import java.util.Arrays;
import java.util.Scanner;

// https://www.luogu.com.cn/problem/P1966
class MatchSeq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] row1 = new int[n];
        int[] row2 = new int[n];
        for (int i = 0; i < n; i++) {
            row1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            row2[i] = scanner.nextInt();
        }

        // 两行火柴顺序对齐

        // 离散化
        discretize(row1);
        discretize(row2);

        // 映射
        int[] map = new int[n];
        for (int i = 0; i < n; i++) {
            map[row1[i]] = i;
        }
        for (int i = 0; i < n; i++) {
            row2[i] = map[row2[i]];
        }

        // 使序列有序的最少交换次数 = 逆序对数
        // 求逆序对数
        System.out.println(mergeSort(row2, 0, n - 1) % 99999997);
        scanner.close();
    }

    private static void discretize(int[] num) {
        Integer[] index = new Integer[num.length];
        for (int i = 0; i < num.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (i, j) -> Integer.compare(num[i], num[j])); // 下标
        for (int i = 0; i < num.length; i++) {
            num[index[i]] = i;
        }
    }

    private static long mergeSort(int[] num, int l, int r) {
        if (l >= r)
            return 0;

        int mid = (l + r) >> 1;
        long rev = mergeSort(num, l, mid) + mergeSort(num, mid + 1, r);
        if (num[mid] > num[mid + 1]) { // merge
            int[] tmp = new int[r - l + 1];
            int i = l, j = mid + 1, k = 0;
            while (i <= mid && j <= r) {
                if (num[i] <= num[j]) {
                    tmp[k++] = num[i++];
                } else {
                    rev += (mid - i + 1);
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
        return rev;
    }
}