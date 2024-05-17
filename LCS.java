// Time & Space = O (s1.length * s2.length)

import java.util.Scanner;

public class LCS {

    public static int lcs(String s1, String s2) {
        Integer[][] dp = new Integer[s1.length() + 1][s2.length() + 1];

        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                dp[i][j] = 0;
            }
        }

        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(lcs(s1, s2));

    }

}

// for (int row = 0; row < dp.length; row++) {
// for (int col = 0; col < dp[row].length; col++) {
// System.out.print(dp[row][col] + " ");
// }
// System.out.println();
// }
