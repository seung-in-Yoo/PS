import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] cost = new int[N][3];
        
        for (int i = 0; i < N; i++) {
            cost[i][0] = sc.nextInt();
            cost[i][1] = sc.nextInt();
            cost[i][2] = sc.nextInt();
        }
        int answer = INF;

        for (int first = 0; first < 3; first++) {
            int[][] dp = new int[N][3];
            
            for (int c = 0; c < 3; c++) {
                if (c == first) { 
                    dp[0][c] = cost[0][c];
                }
                else { 
                    dp[0][c] = INF;
                }
            }
            
            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
            }
            
            for (int last = 0; last < 3; last++) {
                if (last == first) {
                    continue;
                }
                answer = Math.min(answer, dp[N-1][last]);
            }
        }
        System.out.println(answer);
    }
}
