class Solution {
    public int[] closestPrimes(int left, int right) {
        // 欧拉筛
        List<Integer> primes = new ArrayList<Integer>();
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }

            for (int p : primes) {
                if (i * p > right)
                    break;

                isPrime[i * p] = false;
                if (i % p == 0)
                    break;
            }
        }

        // 枚举
        int[] closest = { -1, -1 };
        int minDiff = Integer.MAX_VALUE;
        int prev = 1;
        for (int i = left; i <= right && minDiff > 2; i++) {
            if (isPrime[i]) {
                if (prev >= 2) {
                    int diff = i - prev;
                    if (diff < minDiff) {
                        minDiff = diff;
                        closest[0] = prev;
                        closest[1] = i;
                    }
                }
                prev = i;
            }
        }
        return closest;
    }
}