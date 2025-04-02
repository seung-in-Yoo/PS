import java.util.*;

// 현재 범위가 커서 시간복잡도 신경 써야함 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long K = sc.nextLong(); // K의 범위가 크므로 long

        long prefixSum = 0;
        long count = 0;
        Map<Long, Long> SumCount = new HashMap<>(); // 해시맵을 사용하여 누적 합 계산 
        SumCount.put(0L, 1L); 

        for (int i = 0; i < N; i++) {
            long num = sc.nextLong();
            prefixSum += num;

            // (prefixSum - K)가 해시맵에 있는지 확인
            if (SumCount.containsKey(prefixSum - K)) {
                count += SumCount.get(prefixSum - K);
            }

            // 현재 누적합 저장
            SumCount.put(prefixSum, SumCount.getOrDefault(prefixSum, 0L) + 1);
        }

        System.out.println(count);
    }
}