import java.util.*;

class StackPerm {
    static Boolean check(int arr1[], int arr2[]) {
        Stack<Integer> stk = new Stack<Integer>();
        int j = 0;
        for (int i = 0; i < arr1.length; i++) {
            stk.push(arr1[i]);
            while (!stk.isEmpty() && stk.peek() == arr2[j]) {
                stk.pop();
                j++;
            }
        }
        return stk.isEmpty();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length ");
        int n = sc.nextInt();
        int input[] = new int[n];
        int output[] = new int[n];
        System.out.println("Input Array");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element at index " + i + " :- ");
            input[i] = sc.nextInt();
        }
        System.out.println("Output Array");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element at index " + i + " :- ");
            output[i] = sc.nextInt();
        }
        System.out.println("Are they permutations : " + check(input, output));
        sc.close();
    }
}
