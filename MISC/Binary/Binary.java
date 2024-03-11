import java.util.function.Function;

// 二分模板
public class Binary {
    static int[] nums;

    public static void main(String[] args) {
        nums = new int[] { 1, 2, 3, 5, 5, 5, 8, 9 };

        // 二分
        // int l = 0, r = nums.length - 1;
        // while (l < r) {
        // int mid = (l + r) >> 1;
        // if (check1(mid)) {
        // r = mid;
        // } else {
        // l = mid + 1;
        // }
        // }

        Function<Integer, Boolean> check1 = n -> nums[n] >= 5;
        int i = binarySearch(check1);
        System.err.printf("第一个>=5的元素 nums[%d] = %d%n", i, nums[i]);

        Function<Integer, Boolean> check2 = n -> nums[n] > 5;
        i = binarySearch(check2);
        System.err.printf("第一个>5的元素 nums[%d] = %d%n", i, nums[i]);

        i = binarySearch(check1);
        System.err.printf("最后一个<5的元素 nums[%d] = %d%n", i - 1, nums[i - 1]);

        i = binarySearch(check2);
        System.err.printf("最后一个<=5的元素 nums[%d] = %d%n", i - 1, nums[i - 1]);

        Function<Integer, Boolean> check = n -> nums[n] >= 12;
        i = binarySearch(check);
        System.err.printf("%d%n", i);
    }

    public static int binarySearch(Function<Integer, Boolean> check) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check.apply(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // 000...111 找第一个1的位置
    public static boolean check1(int n) {
        return nums[n] >= 5;
    }

    public static boolean check2(int n) {
        return nums[n] > 5;
    }
}
