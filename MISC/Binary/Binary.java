import java.util.function.Function;

// 二分模板
public class Binary {
    static int[] nums;

    public static void main(String[] args) {
        nums = new int[] { 1, 2, 3, 5, 5, 5, 8, 9 };

        // int l = 0, r = nums.length;
        // while (l < r) {
        // int mid = (l + r) >> 1;
        // if (check(mid)) {
        // r = mid;
        // } else {
        // l = mid + 1;
        // }
        // }

        Function<Integer, Boolean> check1 = n -> nums[n] >= 5;
        int i = binarySearch(check1);
        System.out.printf("第一个>=5的元素 nums[%d] = %d%n", i, nums[i]);

        Function<Integer, Boolean> check2 = n -> nums[n] > 5;
        i = binarySearch(check2);
        System.out.printf("第一个>5的元素 nums[%d] = %d%n", i, nums[i]);

        i = binarySearch(check1);
        System.out.printf("最后一个<5的元素 nums[%d] = %d%n", i - 1, nums[i - 1]);

        i = binarySearch(check2);
        System.out.printf("最后一个<=5的元素 nums[%d] = %d%n", i - 1, nums[i - 1]);

        Function<Integer, Boolean> check3 = n -> nums[n] >= 12;
        i = binarySearch(check3);
        System.out.printf("%d%n", i);

        Function<Integer, Boolean> check4 = n -> nums[n] < 5;
        i = binarySearch2(check4);
        System.out.printf("第一个>=5的元素 nums[%d] = %d%n", i + 1, nums[i + 1]);

        Function<Integer, Boolean> check5 = n -> nums[n] <= 5;
        i = binarySearch2(check5);
        System.out.printf("第一个>5的元素 nums[%d] = %d%n", i + 1, nums[i + 1]);

        i = binarySearch2(check4);
        System.out.printf("最后一个<5的元素 nums[%d] = %d%n", i, nums[i]);

        i = binarySearch2(check5);
        System.out.printf("最后一个<=5的元素 nums[%d] = %d%n", i, nums[i]);

        Function<Integer, Boolean> check6 = n -> nums[n] < 12;
        i = binarySearch2(check6);
        System.out.printf("%d%n", i);
    }

    public static int binarySearch(Function<Integer, Boolean> check) { // 000...111 找第一个1的位置
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check.apply(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public static int binarySearch2(Function<Integer, Boolean> check) { // 111...000 找最后一个1的位置
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check.apply(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static boolean check1(int n) {
        return nums[n] >= 5;
    }
}
