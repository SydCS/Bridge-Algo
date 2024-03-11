class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] seats = new int[n];
        int[] diff = new int[n + 1];

        for (int[] booking : bookings) {
            diff[booking[0] - 1] += booking[2];
            if (booking[1] <= n)
                diff[booking[1]] -= booking[2];
        }

        seats[0] = diff[0];
        for (int i = 1; i < n; i++) {
            seats[i] = seats[i - 1] + diff[i - 1];
        }
        return seats;
    }
}