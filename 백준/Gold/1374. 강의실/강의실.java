import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] lecture = new int[n][2]; 
        for (int i = 0;i < n;i++) {
            int no = sc.nextInt(); 
            int start = sc.nextInt();
            int end = sc.nextInt();
            lecture[i][0] = start;
            lecture[i][1] = end;
        }

        Arrays.sort(lecture, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0;i < n;i++) {
            int start = lecture[i][0];
            int end = lecture[i][1];
            
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll(); 
            }
            pq.offer(end);
        }

        System.out.println(pq.size());
    }
}
