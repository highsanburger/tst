import java.util.*;

class LBS {

    // Time : O(n^2)
    public static int lbs(int[] arr) {
        int[] lis = new int[arr.length];
        Arrays.fill(lis, 1);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
            }
        }

        int[] lds = new int[arr.length];
        Arrays.fill(lds, 1);
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[i] > arr[j] && lds[i] < lds[j] + 1)
                    lds[i] = lds[j] + 1;
            }
        }

        int max = lis[0] + lds[0] - 1;
        for (int i = 1; i < arr.length; i++) {
            if (lis[i] + lds[i] - 1 > max)
                max = lis[i] + lds[i] - 1;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] n0 = { 4, 2, 5, 9, 7, 6, 10, 3, 1 };
        int[] n1 = { 1, 11, 2, 10, 4, 5, 2, 1 };
        int[] n2 = { 12, 11, 40, 5, 3, 1 };
        int[] n3 = { 80, 60, 30, 40, 20, 10 };
        System.out.println(lbs(n0));
        System.out.println(lbs(n1));
        System.out.println(lbs(n2));
        System.out.println(lbs(n3));
    }
}
