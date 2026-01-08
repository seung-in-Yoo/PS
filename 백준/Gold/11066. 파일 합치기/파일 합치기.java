import java.util.*;

public class Main {
    static int[] files;
    static int[] sum;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 
        while (T-->0) {
            int K = sc.nextInt();
            files = new int[K+1];
            sum = new int[K+1];
            dp = new int[K+1][K+1];

            // 입력,누적합 계산
            for (int i = 1; i <= K; i++) {
                files[i] = sc.nextInt();
                sum[i] = sum[i-1] + files[i];
            }

            for (int len=2; len<=K; len++) {
                for (int i=1; i<=K-len+1; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int cost = dp[i][k] + dp[k+1][j] + sum[j] - sum[i-1];
                        dp[i][j] = Math.min(dp[i][j], cost);
                    }
                }
            }

            System.out.println(dp[1][K]);
        }
    }
}
