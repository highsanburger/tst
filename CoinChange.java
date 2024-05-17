import java.util.*;

public class CoinChange {

    public static int coinChange(int[] denoms, int amt) {
        int[] dp = new int[amt + 1];
        Arrays.fill(dp, amt + 1);
        dp[0] = 0;

        for (int i = 1; i <= amt; i++) {
            for (int denom : denoms) {
                if (i - denom >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - denom]);
                }
            }
        }
        return (dp[amt] != amt + 1) ? dp[amt] : -1;
    }

    public static void main(String[] args) {

        System.out.println("Enter Number of Denominations :- ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] denoms = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter denomination " + i);
            denoms[i] = sc.nextInt();
        }
        System.out.println("Enter Amount :- ");
        int amt = sc.nextInt();
        System.out.println("Number of coins required = " + CoinChange(denoms, amt));
        sc.close();
    }

}
