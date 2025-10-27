import java.util.*;

public class Main {
    static int N, M;
    static int[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N];
        int max = 0;
        int min = 10000;

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }

        int left = 0;
        int right = max - min;
        int result = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canDivide(mid)) {
                result = mid;         
                right = mid - 1;      
            } else {
                left = mid + 1;       
            }
        }

        System.out.println(result);
    }

    static boolean canDivide(int maxScore) {
        int count = 1;
        int min = A[0];
        int max = A[0];

        for (int i = 1; i < N; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);

            if (max - min > maxScore) {
                count++;
                min = A[i];
                max = A[i];
            }
        }

        return count <= M;
    }
}
