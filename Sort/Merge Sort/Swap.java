import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Swap {
    public static void main(String[] args) {
        int[] arr = { 5, 1, 3, 2, 4, 7, 6, 8 };
        System.out.println(getMinSwap(arr));
    }

    public static int getMinSwap(int[] arr) {
        int n = arr.length;
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>(); // 元素 -> 索引
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        int loops = 0; // 置换环的个数
        boolean[] visited = new boolean[n]; // 标志每个元素是否被访问过
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int j = i;
                // visited[i] 为 true 时，回到起点，找到一个环
                while (!visited[i]) {
                    j = map.get(sorted[j]);
                    visited[j] = true;
                }
                loops++;
            }
        }

        return n - loops;
    }
}
