import java.util.Scanner;

// 팰린드롬 판별 + DP 
public class Main {
    static final int INF = 2501;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();

        boolean[][] isPalin = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            isPalin[i][i] = true;
        }

        for (int len = 2; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                int end = start + len - 1;

                if (s.charAt(start) == s.charAt(end)) {
                    if (len == 2) {
                        isPalin[start][end] = true;
                    } else {
                        isPalin[start][end] = isPalin[start + 1][end - 1];
                    }
                }
            }
        }

        
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = INF;

            for (int j = 0; j <= i; j++) {
                if (isPalin[j][i]) {
                    if (j == 0) {
                        dp[i] = 1; 
                    } else {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }

        System.out.println(dp[n - 1]);
    }
}
