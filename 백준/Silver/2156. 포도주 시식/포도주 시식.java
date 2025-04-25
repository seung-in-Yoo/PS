import java.util.*;

// DP -> 연속으로 3잔마시기 X, 가장 많은 양 포도주 마시기 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] wine = new int[n+1];
        
        for (int i=1; i<=n; i++) {
            wine[i] = sc.nextInt();
        }
        
        int[] dp = new int[n+1];
        
        // 1~3까지 값 처리 
        if (n >= 1) {
            dp[1] = wine[1];
        }
        if (n >= 2) {
            dp[2] = wine[1] + wine[2];
        }
        if (n >= 3) {
            dp[3] = Math.max(
            Math.max(dp[2], wine[1] + wine[3]),
            wine[2] + wine[3]
            );
        }
        
        // 4번째부터 최대 양 찾는 점화식 적용 
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(
                Math.max(dp[i - 1], dp[i - 2] + wine[i]),
                dp[i - 3] + wine[i - 1] + wine[i]
            );
        }
        
        System.out.println(dp[n]);
    }
}