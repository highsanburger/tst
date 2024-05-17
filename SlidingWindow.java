import java.util.*;

public class SlidingWindow {

    public static int[] maxSlidingWindow(int[] arr, int winLen) {
        if (arr.length == 0 || winLen == 0) {
            return new int[0];
        }
        int[] result = new int[arr.length - winLen + 1]; // number of windows
        Deque<Integer> win = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < arr.length; ++i) {
            // remove indices that are out of bound
            while (win.size() > 0 && win.peekFirst() <= i - winLen) {
                win.pollFirst();
            }
            // remove indices whose corresponding values are less than nums[i]
            while (win.size() > 0 && arr[win.peekLast()] < arr[i]) {
                win.pollLast();
            }
            // add nums[i]
            win.offerLast(i);
            // add to result
            if (i >= winLen - 1) {
                result[i - winLen + 1] = arr[win.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int ans[] = maxSlidingWindow(a, k);
        for (int i = 0; i < ans.length; i++)
            System.out.print(ans[i] + " ");
        sc.close();
    }

}
