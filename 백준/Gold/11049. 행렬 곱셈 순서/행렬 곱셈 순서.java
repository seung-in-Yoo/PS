import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp;
    static int[] d; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        d = new int[N+1];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            d[i] = r;
            d[i+1] = c;
        }

        // DP 계산
        for (int len = 1; len < N; len++) { // 부분 행렬 길이
            for (int i = 0; i + len < N; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k=i; k<j; k++) {
                    int cost = dp[i][k] + dp[k+1][j] + d[i] * d[k+1] * d[j+1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        System.out.println(dp[0][N - 1]);
    }
}
