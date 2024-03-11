import java.util.Scanner;

public class EKO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 树木数量
        int M = scanner.nextInt(); // 需要的木材总长度
        int[] trees = new int[N];
        int maxTreeHeight = 0;

        // 读取每棵树的高度并找出最高的树
        for (int i = 0; i < N; i++) {
            trees[i] = scanner.nextInt();
            maxTreeHeight = Math.max(maxTreeHeight, trees[i]);
        }

        // 二分查找
        int l = 0;
        int r = maxTreeHeight;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(trees, mid, M)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l - 1);
        scanner.close();
    }

    // 计算在给定高度下获得的木材长度
    private static boolean check(int[] trees, int height, int M) {
        long sum = 0;
        for (int tree : trees) {
            if (tree > height) {
                sum += tree - height;
            }
        }
        return sum < M;
    }
}
