import java.util.*;

public class Main {
    static class Researcher implements Comparable<Researcher> {
        int start, duration;

        Researcher(int start, int duration) {
            this.start = start;
            this.duration = duration;
        }

        public int compareTo(Researcher other) {
            return this.start - other.start;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Researcher[] researcher = new Researcher[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int s = sc.nextInt();
            researcher[i] = new Researcher(a, s);
        }

        Arrays.sort(researcher);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int saved = 0;

        for (Researcher r : researcher) {
            int arrival = r.start;

            while (!pq.isEmpty() && pq.peek() + m < arrival) {
                pq.poll();
            }

            if (!pq.isEmpty() && pq.peek() <= arrival) {
                pq.poll();
                saved++;
            }
            pq.offer(arrival + r.duration);
        }

        System.out.println(saved);
    }
}
