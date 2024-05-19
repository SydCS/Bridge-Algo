import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] heightStr = scanner.nextLine().split(" ");
        scanner.close();

        int n = heightStr.length;
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(heightStr[i]);
        }

        // O(n^2)
        // int[] dpLNIS = new int[n]; // Longest Non-Increasing Sequence
        // int lnis = 1;
        // int[] dpLIS = new int[n]; // Longest Increasing Sequence
        // int lis = 1;

        // for (int i = 0; i < n; i++) {
        // int maxLNIS = 1, maxLIS = 1;
        // for (int j = 0; j < i; j++) {
        // if (heights[j] >= heights[i]) {
        // maxLNIS = Math.max(dpLNIS[j] + 1, maxLNIS);
        // }
        // if (heights[j] < heights[i]) {
        // maxLIS = Math.max(dpLIS[j] + 1, maxLIS);
        // }
        // }
        // dpLNIS[i] = maxLNIS;
        // dpLIS[i] = maxLIS;
        // lnis = Math.max(lnis, maxLNIS);
        // lis = Math.max(lis, maxLIS);
        // }

        // System.out.println(lnis);
        // System.out.println(lis);

        // O(n \log n)
        int[] tailLNIS = new int[n];
        int lenLNIS = 0;
        int[] tailLIS = new int[n];
        int lenLIS = 0;

        for (int h : heights) {
            int l = 0, r = lenLNIS;
            while (l < r) {
                int mid = (l + r) / 2;
                if (tailLNIS[mid] < h)
                    r = mid;
                else
                    l = mid + 1;
            }
            tailLNIS[l] = h;
            if (l == lenLNIS) {
                lenLNIS++;
            }

            l = 0;
            r = lenLIS;
            while (l < r) {
                int mid = (l + r) / 2;
                if (tailLIS[mid] >= h)
                    r = mid;
                else
                    l = mid + 1;
            }
            tailLIS[l] = h;
            if (l == lenLIS) {
                lenLIS++;
            }
        }

        System.out.println(lenLNIS);
        System.out.println(lenLIS);
    }
}
