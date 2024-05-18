import java.util.*;

public class SubsetSum {

    public static boolean canPartition(int[] arr, int target) {
        Set<Integer> dp = new HashSet<Integer>();
        dp.add(0);

        for (int i = arr.length - 1; i >= 0; i--) {
            Set<Integer> temp = new HashSet<Integer>();
            for (Integer d : dp) {
                temp.add(d + arr[i]);
                temp.add(d);
            }
            dp = temp;
        }

        return (dp.contains(target) ? true : false);
    }

    public static void main(String[] args) {

        System.out.println("Enter length :- ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element at " + i);
            arr[i] = sc.nextInt();
        }
        int target = 0;
        for (int a : arr) {
            target += a;
        }
        target = target / 2;
        System.out.println(canPartition(arr, target));
        sc.close();
    }
}
