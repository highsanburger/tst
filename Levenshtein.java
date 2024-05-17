import java.util.*;

public class Levenshtein {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String w1 = sc.next();
        String w2 = sc.next();
        System.out.println(editDist(w1, w2));
    }

    public static int editDist(String w1, String w2) {
        int[][] dp = new int[w1.length() + 1][w2.length() + 1];

        for (int i = 0; i <= w1.length(); i++) {
            dp[i][w2.length()] = w1.length() - i;
        }
        for (int j = 0; j <= w2.length(); j++) {
            dp[w1.length()][j] = w2.length() - j;
        }

        for (int i = w1.length() - 1; i >= 0; i--) {
            for (int j = w2.length() - 1; j >= 0; j--) {
                if (w1.charAt(i) == w2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1]));
                }
            }

        }
        return dp[0][0];
    }
}
