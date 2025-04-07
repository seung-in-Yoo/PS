import java.util.*;

// 이진탐색으로 자르는 나무의 최대 높이 찾기 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 나무의 수
        int M = sc.nextInt(); // 가져가야하는 나무 높이(M 미터)
        
        int[] tree = new int[N];
        int maxHeight = 0; // 가장 큰 나무 높이
        
        for (int i = 0; i < N; i++) {
            tree[i] = sc.nextInt();
            if (tree[i] > maxHeight) {
                maxHeight = tree[i];
            }
        }
        
        int left = 0;
        int right = maxHeight;
        int result = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;
            
            for (int i = 0; i < N; i++) {
                if (tree[i] > mid) {
                    sum += tree[i] - mid;
                }
            }

            if (sum >= M) {
                result = mid;       // 현재 높이 저장
                left = mid + 1;     // 더 높이 자를 수 있는지 확인
            } else {
                right = mid - 1;    // 너무 많이 잘랐으니 낮춰야 함
            }
        }
        
        System.out.println(result);
    }
}
