//Subset problem using Dp(Tabulation) 
class SubSum {

    public static boolean subsetSum(int[] arr, int k) {
        int n = arr.length;

        // T[i][j] stores true if subset with sum j can be attained using items up to
        // first i items
        boolean[][] T = new boolean[n + 1][k + 1];

        // if the sum is zero
        for (int i = 0; i <= n; i++) {
            T[i][0] = true;
        }

        // do for i'th item
        for (int i = 1; i <= n; i++) {
            // consider all sum from 1 to sum
            for (int j = 1; j <= k; j++) {
                // don't include the i'th element if j-A[i-1] is negative
                if (arr[i - 1] > j) {
                    T[i][j] = T[i - 1][j];
                } else {
                    // find the subset with sum j by excluding or including
                    // the i'th item
                    T[i][j] = T[i - 1][j] || T[i - 1][j - arr[i - 1]];
                }
            }
        }
        /*
         * Print Dynamic Table
         * 
         * for(int i=0;i<=n;i++)
         * {
         * for(int j=0;j<=k;j++)
         * System.out.print(T[i][j] + "  ");
         * System.out.println();
         * }
         */
        // return maximum value
        return T[n][k];
    }

    public static void main(String[] args) {
        // Input: a set of items and a sum
        int[] A = { 2, 3, 5, 6, 8, 10 };
        int k = 10;

        if (subsetSum(A, k)) {
            System.out.println("Subsequence with the given sum exists");
        } else {
            System.out.println("Subsequence with the given sum does not exist");
        }
    }
}
