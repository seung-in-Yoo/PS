import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 후보의 수
        int dasom = sc.nextInt(); // 다솜이의 번호
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 큐 사용
        
        for (int i=1; i<N; i++) {
            pq.add(sc.nextInt()); // 다솜이는 입력받는거 빼놨기때문에 i=1부터 시작
        }
        
        int count = 0; // 매수한 사람의 수
        
        while(!pq.isEmpty() && pq.peek() >= dasom) {
            int max = pq.poll(); // 표 가장 많은 후보에서 한표 빼고 다솜이한테 주기 
            max--;
            dasom++;
            count++;
            
            pq.add(max);
        }
        
        System.out.println(count);
    }
}