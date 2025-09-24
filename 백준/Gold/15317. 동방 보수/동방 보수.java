import java.util.*;

public class Main {

    static int N, M;
    static long X; // 최대 지원 금액
    static long[] C; // 동방 보수 비용
    static long[] S; // 동아리 예산

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        X = sc.nextLong();

        C = new long[N];
        S = new long[M];

        for (int i = 0; i < N; i++) {
            C[i] = sc.nextLong();
        }

        for (int i = 0; i < M; i++) {
            S[i] = sc.nextLong();
        }
        
        // 둘다 정렬 
        Arrays.sort(C); 
        Arrays.sort(S); 

        int left = 0;
        int right = Math.min(N, M);
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canMatchK(mid)) {
                answer = mid;
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static boolean canMatchK(int k) {
        // 가장 싼 k개의 방과 가장 돈 많은 k개의 동아리
        long need = 0;

        for (int i = 0; i < k; i++) {
            long cost = C[i];   
            long budget = S[M - k + i];

            if (budget < cost) {
                need += (cost - budget);
                if (need > X) { return false; } // 초과하면 실패
            }
        }

        return true;
    }
}
