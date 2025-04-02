import java.util.*;

// 시간초과...?
// 처음에 문제가 이해가 잘 안갔는데 우선순위 큐 활용하는 생각보다 쉬운 문제
public class Main { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선순위 큐 (작은 순서대로 자동 정렬)
        
        for(int i = 0; i<N; i++) {
            pq.offer(sc.nextInt()); // pq.add(sc.nextInt);
        }
        int total = 0;
        
        // 최소한의 비교로 카드 묶음 합치기 
        while(pq.size() > 1) {
            int first = pq.poll(); // 가장 작은 값 꺼내기 
            int second = pq.poll();
            int count = first + second;
            total += count;
            pq.offer(count);
        }
        System.out.println(total);
    }
}