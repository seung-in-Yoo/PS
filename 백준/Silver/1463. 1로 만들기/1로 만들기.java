import java.util.*;

// 문제유형-> 연산을 최소로 해야하기에 DP
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N + 1]; 

        dp[1] = 0; // 1은 연산 안 해도 되니까 0

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 1을 빼는 연산

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 2로 나누는 경우 
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 3으로 나누는 경우
            }
        }

        System.out.println(dp[N]);
    }
}
