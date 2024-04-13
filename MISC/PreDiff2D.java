// 二维
public class PreDiff2D {
    public static void main(String[] args) {
        final int n = 3, m = 4;
        final int[][] matrix = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = (i - 1) * m + j;
            }
        }
        print(matrix);
        System.out.println();

        int[][] prefix = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefix[i][j] = matrix[i][j] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }
        print(prefix);
        System.out.println();

        int diffOfPrefix = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                diffOfPrefix = prefix[i][j] - prefix[i - 1][j] - prefix[i][j - 1] + prefix[i - 1][j - 1];
                System.out.print(diffOfPrefix + " ");
            }
            System.out.println();
        }
        System.out.println();

        int[][] diff = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                diff[i][j] = matrix[i][j] - matrix[i - 1][j] - matrix[i][j - 1] + matrix[i - 1][j - 1];
            }
        }
        print(diff);
        System.out.println();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1];
                System.out.print(diff[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print(int[][] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
}
