import java.util.*;

public class LIS {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int[] in = new int[n];
        // for (int i = 0; i < n; i++) {
        // in[i] = sc.nextInt();
        // }
        int[] in = { 10, 22, 33, 50, 60, 80 };
        // int[] in = { 0, 1, 3, 2, 4 };
        System.out.println(LIS_DP(in));
        // System.out.println(LIS_Rec(in, 0, in.length, Integer.MIN_VALUE));
    }

    // Time: O(n^2)
    // Space: O(n)
    public static int LIS_DP(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        System.out.println("len:- " + arr.length);

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        return dp[0];
        // for (int row = 0; row < dp.length; row++) {
        // System.out.print(dp[row] + " ");
        // }
        // System.out.println();
        // System.out.println();
        // Arrays.sort(dp);
        //
        // for (int row = 0; row < dp.length; row++) {
        // System.out.print(dp[row] + " ");
        // }
        // System.out.println();

    }

    // Time: O(2^n)
    // Space: O(n)
    public static int LIS_Rec(int[] arr, int i, int n, int prev) {
        if (i == n) {
            return 0;
        }
        int excl = LIS_Rec(arr, i + 1, n, prev);
        int incl = 0;
        if (arr[i] > prev) {
            incl = 1 + LIS_Rec(arr, i + 1, n, arr[i]);
        }
        return Integer.max(incl, excl);
    }

}
