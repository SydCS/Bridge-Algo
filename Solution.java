class Solution {
    private static final int M = 100;
    private static final boolean[] PRIME = new boolean[M];

    public int maximumPrimeDifference(int[] nums) {
        isPrime(M);
        int first = -1, maxDist = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (PRIME[nums[i]]) {
                if (first == -1)
                    first = i;
                else
                    maxDist = Math.max(maxDist, i - first);
            }
        }
        return maxDist;
    }

    private boolean isPrime(int n) {
        PRIME = new boolean[n + 1];
        Arrays.fill(PRIME, true);
        PRIME[0] = PRIME[1] = false;

        for (int i = 2; i <= n; i++) {
            if (PRIME[i] == true) {
                for (int j = i; j * i <= n; j++) {
                    PRIME[j * i] = false;
                }
            }
        }
        return PRIME[n];
    }
}