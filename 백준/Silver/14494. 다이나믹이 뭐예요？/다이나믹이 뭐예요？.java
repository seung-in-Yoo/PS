import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1_000_000_007; // 오버플로우 발생하지 않기 위해 사용 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 
        
        int[][] dp = new int[n + 1][m + 1];

        // 시작점 정의
        dp[1][1] = 1;

        // DP 사용해서 점화식으로 풀면 됨 
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue;

                dp[i][j] = ((dp[i - 1][j] + dp[i][j - 1]) % MOD + dp[i - 1][j - 1]) % MOD;
            }
        }

        System.out.println(dp[n][m]); 
    }
}
