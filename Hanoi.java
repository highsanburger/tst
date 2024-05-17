import java.util.*;

public class Hanoi {
    static void iterHanoi(int n, char src, char aux, char dst) {

        // Create three stacks to represent the three rods
        Stack<Integer> srcStk = new Stack<>();
        Stack<Integer> auxStk = new Stack<>();
        Stack<Integer> dstStk = new Stack<>();

        // Initialize the source rod with disks
        for (int i = n; i >= 1; i--) {
            srcStk.push(i);
        }

        // Total number of moves required
        int totalMoves = (int) Math.pow(2, n) - 1;

        // Determine the order of pegs for odd/even number of disks
        char temp;
        if (n % 2 == 0) {
            temp = aux;
            aux = dst;
            dst = temp;
        }

        // Perform iterative Tower of Hanoi
        for (int move = 1; move <= totalMoves; move++) {
            if (move % 3 == 1) {
                moveDisk(srcStk, dstStk, src, dst);
            } else if (move % 3 == 2) {
                moveDisk(srcStk, auxStk, src, aux);
            } else if (move % 3 == 0) {
                moveDisk(auxStk,
                        dstStk, aux, dst);
            }
        }
    }

    public static void recHanoi(int n, char src, char aux, char des) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + src + " to " + des);
            return;
        }
        recHanoi(n - 1, src, des, aux);
        System.out.println("Move disk " + n + " from " + src + " to " + des);
        recHanoi(n - 1, aux, src, des);
    }

    static void moveDisk(Stack<Integer> srcStk, Stack<Integer> dstStk, char src, char dst) {
        if (!srcStk.isEmpty() && (dstStk.isEmpty() || srcStk.peek() < dstStk.peek())) {
            dstStk.push(srcStk.pop());
            System.out.println("Move disk " + dstStk.peek() + " from " + src + " to " + dst);
        } else {
            srcStk.push(dstStk.pop());
            System.out.println("Move disk " + srcStk.peek() + " from " + dst + " to " + src);
        }
    }

    public static void main(String[] args) {
        iterHanoi(3, 'A', 'B', 'C');
        System.out.println();
        recHanoi(3, 'A', 'B', 'C');

    }

}
