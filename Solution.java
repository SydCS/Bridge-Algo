class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> q = new ArrayDeque<>(); // 存放下标
        for (int i = 0; i < n; i++) {
            // 入
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.pollLast();
            }
            q.addLast(i);

            // 出
            if (i - q.peekFirst() >= k) {
                q.pollFirst();
            }

            // 记录答案
            if (i >= k - 1) {
                ans[i - k + 1] = nums[q.peekFirst()];
            }
        }
        return ans;
    }
}