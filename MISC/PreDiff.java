// 前缀和、差分模板
public class PreDiff {
    public static void main(String[] args) {
        int n = 5;
        int[] nums = new int[n + 1]; // (0) 1 4 9 16 25
        int[] prefix = new int[n + 1]; // (0) 1 5 14 30 55
        int[] diff = new int[n + 1]; // (0) 1 3 5 7 9

        for (int i = 1; i <= n; i++) {
            nums[i] = i * i;
            prefix[i] = prefix[i - 1] + nums[i];
            diff[i] = nums[i] - nums[i - 1];
        }

        int prefixOfDiff = 0;
        for (int i = 1; i <= n; i++) {
            prefixOfDiff += diff[i];
            System.out.print(prefixOfDiff + " ");
        }
        System.out.println();

        int diffOfPrefix = 0;
        for (int i = 1; i <= n; i++) {
            diffOfPrefix = prefix[i] - prefix[i - 1];
            System.out.print(diffOfPrefix + " ");
        }
    }
}
