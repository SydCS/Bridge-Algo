import java.util.*;

// TODO
public class Main {
    static int[] citations;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 论文数量
        int L = scanner.nextInt(); // 最多引用论文数量
        citations = new int[N];
        for (int i = 0; i < N; i++) {
            citations[i] = scanner.nextInt();
        }
        Arrays.sort(citations);

        int h = binarySearch(L);
        System.out.println(h);
        scanner.close();
    }

    private static int binarySearch(int L) {
        int l = 0, r = citations.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(mid, L)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r - 1;
    }

    private static boolean check(int H, int L) {
        int count = 0;
        for (int i = citations.length - 1; i >= citations.length - H; i--) {
            if (citations[i] < H - 1) {
                return false;
            } else if (citations[i] == H - 1) {
                count++;
            }
        }
        return count > L;
    }
}
