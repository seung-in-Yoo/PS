import java.util.*;

// 2차원 배열을 사용하는 DP 문제 -> 물건의 무게를 고려하여 가치를 최대화시키기
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 물품의 수
        int K = sc.nextInt(); // 버틸수 있는 무게
        
        int[] W = new int[N+1]; // 각 물건의 무게
        int[] V = new int[N+1]; // 각 물건의 가치
        
        for (int i=1; i<=N; i++) {
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }
        
        int[][] dp = new int[N+1][K+1];
        
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=K; j++) {
                if (W[i] > j) {
                    // 물건을 더 넣을 수 없으면 이전 결과 
                    dp[i][j] = dp[i-1][j];
                } else {
                    // 안 넣고 이전 결과 쓰거나 넣고 가치 추가한것중에 최대인 것
                    dp[i][j] = Math.max(
                        dp[i - 1][j],
                        dp[i - 1][j - W[i]] + V[i]
                    );
                }
            }
        }
        
        System.out.println(dp[N][K]);
    }
}