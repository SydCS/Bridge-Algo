class Solution {
    public int maxScore(String s) {
        int len = s.length();
        int[] sum = new int[len + 10];
        for (int i = 1; i <= len; i++)
            sum[i] = sum[i - 1] + (s.charAt(i - 1) - '0');

        int ans = 0;
        for (int i = 1; i <= len - 1; i++) {
            int a = i - sum[i], b = sum[len] - sum[i];
            ans = Math.max(ans, a + b);
        }
        return ans;
    }
}
