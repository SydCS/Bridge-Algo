import java.util.*;

// https://www.luogu.com.cn/problem/P8755
public class LoadBalancer {
    static class Task {
        int endTime;
        int consumption;

        public Task(int endTime, int consumption) {
            this.endTime = endTime;
            this.consumption = consumption;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 计算机的数量
        int m = scanner.nextInt(); // 任务的数量
        int[] capacities = new int[n + 1]; // 每台计算机的算力
        for (int i = 1; i <= n; i++) {
            capacities[i] = scanner.nextInt();
        }

        // 为每台计算机创建一个优先队列来存储任务
        PriorityQueue<Task>[] tasks = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) {
            tasks[i] = new PriorityQueue<>(Comparator.comparingInt(a -> a.endTime));
        }

        // 处理每个任务
        for (int i = 0; i < m; i++) {
            int arrivalTime = scanner.nextInt();
            int computerId = scanner.nextInt();
            int duration = scanner.nextInt();
            int consumption = scanner.nextInt();

            // 移除所有已经结束的任务
            while (!tasks[computerId].isEmpty() && tasks[computerId].peek().endTime <= arrivalTime) {
                capacities[computerId] += tasks[computerId].poll().consumption;
            }

            // 检查剩余算力是否足够
            if (capacities[computerId] >= consumption) {
                capacities[computerId] -= consumption;
                tasks[computerId].offer(new Task(arrivalTime + duration, consumption));
                System.out.println(capacities[computerId]);
            } else {
                System.out.println(-1);
            }
        }

        scanner.close();
    }
}
