import java.io.*;
import java.util.*;

public class Celebrity {
    public static int findCelebrity(int M[][], int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (M[candidate][i] == 1) {
                candidate = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != candidate && (M[candidate][i] == 1 || M[i][candidate] == 0)) {
                return -1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] relationshipMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                relationshipMatrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(findCelebrity(relationshipMatrix, N));
    }
}
