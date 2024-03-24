class Solution {
    public int reversePairs(int[] record) {
        return mergeSort(record, 0, record.length - 1);
    }

    private int mergeSort(int[] num, int l, int r) {
        if (l >= r)
            return 0;

        int mid = (l + r) >> 1;
        int rev = mergeSort(num, l, mid) + mergeSort(num, mid + 1, r);
        if (num[mid] > num[mid + 1]) { // merge
            int[] tmp = new int[r - l + 1];
            int i = l, j = mid + 1, k = 0;
            while (i <= mid && j <= r) {
                if (num[i] <= num[j]) {
                    tmp[k++] = num[i++];
                } else {
                    rev += (mid - i + 1);
                    tmp[k++] = num[j++];
                }
            }
            while (i <= mid) {
                tmp[k++] = num[i++];
            }
            while (j <= r) {
                tmp[k++] = num[j++];
            }
            System.arraycopy(tmp, 0, num, l, tmp.length);
        }
        return rev;
    }
}