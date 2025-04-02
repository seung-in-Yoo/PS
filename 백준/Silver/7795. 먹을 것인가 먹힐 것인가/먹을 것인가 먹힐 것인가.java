import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int count = 0;
            int[] A = new int[N]; 
            int[] B = new int[M];
            
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < M; i++) {
                B[i] = sc.nextInt();
            }
            
            Arrays.sort(B);
            for (int i = 0; i < N; i++ ) {
                int goal = searchBigA(B,A[i]); // A[i]보다 작은 B의 count 개수를 출력하기
                count += goal;
            }
            System.out.println(count); 
        }
    }
    
    // 이분탐색 함수 구현 
    public static int searchBigA(int[]B, int t) {
        int left = 0;
        int right = B.length;
        while(left < right) {
            int mid = (left + right) / 2;
            if (B[mid] < t) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

