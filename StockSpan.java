import java.util.*;

public class StockSpan {
    static int[] solve(int stock[], int size) {
        int span[] = new int[size];
        Stack<Integer> stk = new Stack<Integer>();
        stk.push(0);
        span[0] = 1;
        for (int i = 1; i < size; i++) {
            while (!stk.isEmpty() && stock[stk.peek()] <= stock[i])
                stk.pop();
            span[i] = (stk.isEmpty()) ? (i + 1) : (i - stk.peek());
            stk.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of days");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter stock on day " + i + " :- ");
            arr[i] = sc.nextInt();
        }
        System.out.print(Arrays.toString(
                solve(arr, n)));
        sc.close();
    }
}
