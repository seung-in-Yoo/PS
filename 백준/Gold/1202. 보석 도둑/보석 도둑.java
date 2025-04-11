import java.io.*;
import java.util.*;

// 그리디-> 가방에는 가장 비싼 보석을 담는것
// 우선순위 큐 -> 가장 비싼 걸 고르기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수

        int[][] jewelInfo = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelInfo[i][0] = Integer.parseInt(st.nextToken()); // 무게
            jewelInfo[i][1] = Integer.parseInt(st.nextToken()); // 가격
        }

        int[] bags = new int[K];
        
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 보석 오름차순 정렬
        Arrays.sort(jewelInfo, Comparator.comparingInt(a -> a[0]));

        // 가방 오름차순 정렬
        Arrays.sort(bags);

        // 최대힙 사용 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long total = 0;
        int jewelIndex = 0;

        for (int i = 0; i < K; i++) {
            int bagWeight = bags[i];

            // 현재 가방에 들어갈 수 있는 보석들을 우선순위 큐에 넣음
            while (jewelIndex < N && jewelInfo[jewelIndex][0] <= bagWeight) {
                pq.add(jewelInfo[jewelIndex][1]); 
                jewelIndex++;
            }

            // 가장 비싼 보석 꺼냄
            if (!pq.isEmpty()) {
                total += pq.poll(); 
            }
        }

        System.out.println(total);
    }
}
