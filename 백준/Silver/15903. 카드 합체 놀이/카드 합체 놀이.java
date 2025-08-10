import java.util.*;

// 그리디 유형 + 우선순위 큐 활용 문제 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextLong());
        }

        for (int i = 0; i < m; i++) {
            long x = pq.poll();
            long y = pq.poll();
            long sum = x + y;
            pq.add(sum);
            pq.add(sum);
        }

        long total = 0;
        while (!pq.isEmpty()) {
            total += pq.poll();
        }

        System.out.println(total);
    }
}