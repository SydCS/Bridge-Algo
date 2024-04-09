import java.util.*;

// https://www.luogu.com.cn/problem/P8661
public class HotPost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), D = scanner.nextInt(), K = scanner.nextInt();
        List<int[]> likes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int ts = scanner.nextInt();
            int id = scanner.nextInt();
            likes.add(new int[] { ts, id });
        }
        scanner.close();
        // 按时间戳排序
        likes.sort(Comparator.comparingInt(a -> a[0]));

        Map<Integer, Integer> map = new HashMap<>(); // id -> 点赞数
        Set<Integer> hotPosts = new TreeSet<>();

        // 滑动窗口 时间D范围内
        int l = 0, r = 0;
        while (r < likes.size()) {
            int[] like = likes.get(r);
            // 增加当前帖子的点赞数
            map.put(like[1], map.getOrDefault(like[1], 0) + 1);
            // 检查窗口是否超过了 D
            while (like[0] - likes.get(l)[0] >= D) {
                map.put(likes.get(l)[1], map.get(likes.get(l)[1]) - 1);
                l++;
            }
            // 检查每个帖子的赞数是否达到 K
            for (int id : map.keySet()) {
                if (map.get(id) >= K) {
                    hotPosts.add(id);
                }
            }
            r++;
        }

        // 输出热帖 ID
        for (int id : hotPosts) {
            System.out.println(id);
        }
    }
}
