import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
            dp[i] = 1; // 길이 1로 초기화
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] > A[i]) { // 감소하는 경우
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]); // dp 배열에서 최대값이 찾기 
        }

        System.out.println(max);
    }
}
