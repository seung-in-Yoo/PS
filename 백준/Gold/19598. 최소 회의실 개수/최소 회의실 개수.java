import java.util.*;

// 우선순위 큐의 최대 크기 -> 최소 필요한 회의실 개수로 생각하여 해결하기 
public class Main {
    static class Meeting implements Comparable<Meeting> {
        int start, end;
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public int compareTo(Meeting other) {
            return this.start - other.start;  // 시작 시간 기준으로 정렬하기 
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Meeting[] meetings = new Meeting[n]; // 회의 정보 저장 
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            meetings[i] = new Meeting(s, e);
        }
        Arrays.sort(meetings); // 시작 시간 기준 정렬 
        // 우선순위 큐 사용해서 현재 진행 중인 회의들의 종료 시간 관리
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(meetings[0].end);
        
        for (int i=1; i<n; i++) {
            Meeting current = meetings[i];
            // 가장 빨리 끝나는 회의가 현재 회의 시작 전에 끝났으면 같은 방을 사용함 
            if (pq.peek() <= current.start) {
                pq.poll();
            }
            pq.offer(current.end);
        }
        // 회의실이 남아있다면 -> 필요한 최소 회의실의 수 
        System.out.println(pq.size());
    }
}
