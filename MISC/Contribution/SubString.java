package Contribution;

import java.util.Scanner;

// https://www.luogu.com.cn/problem/P8715
public class SubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        int count = 0;
        // 贡献法：从一个个字符出发
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int l = 1, r = 1;
            if (i - 1 >= 0) {
                for (int j = i - 1; j >= 0 && s.charAt(j) != c; j--) {
                    l++;
                }
            }
            if (i + 1 < s.length()) {
                for (int j = i + 1; j < s.length() && s.charAt(j) != c; j++) {
                    r++;
                }
            }
            count += l * r;
        }
        System.out.println(count);
        scanner.close();
    }
}
