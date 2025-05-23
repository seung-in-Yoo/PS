import java.util.*;

// 그리디 + 우선순위 큐 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 학생 수
        long M = sc.nextLong(); // 최대 불만도 

        int[] x = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
        }
        
        // 파묻튀를 준 학생들 중 불만도가 가장 큰 학생을 찾기 위해 우선순위 큐 사용 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long currentAngry = 0; // 현재 불만도
        int eggplantCount = 0; // 가지를 준 횟수 

        for (int i = 0; i < N; i++) {
            currentAngry += x[i]; // 파묻튀 주면 불만도 증가
            maxHeap.add(x[i]); 

            // 불만도가 M을 넘으면 가장 큰 x값을 가지로 바꾸기
            while (currentAngry >= M && !maxHeap.isEmpty()) {
                int mostAngry = maxHeap.poll(); // 불만도가 가장 큰 사람 
                currentAngry -= 2 * mostAngry; 
                eggplantCount++;
            }
        }

        System.out.println(eggplantCount);
    }
}
