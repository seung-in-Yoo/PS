import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(); // 이미 가진 랜선 수
        int N = sc.nextInt(); // 필요한 랜선 수
        
        int[] line = new int[K];
        long maxLength = 0; // 랜선 중 가장 긴 길이 

        for (int i = 0; i < K; i++) {
            line[i] = sc.nextInt();
            if (line[i] > maxLength) {
                maxLength = line[i];
            }
        }

        long left = 1;         // 랜선의 최소 길이
        long right = maxLength;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int i = 0; i < K; i++) {
                count += line[i] / mid;  
            }

            if (count >= N) {
                result = mid;        // 이 길이는 가능하니까 저장해두고
                left = mid + 1;      // 더 큰 길이로 시도해보기
            } else {
                right = mid - 1;     // 너무 짧아서 개수가 부족하니까 줄이기
            }
        }

        System.out.println(result);
    }
}
