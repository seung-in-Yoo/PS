import java.io.*;
import java.util.*;

// 그리디 + 우선순위 큐 : 
public class Main {
    static class Lecture implements Comparable<Lecture> { // 수업 정보 저장하는 클래스 선언 
        int start, end;
        Lecture(int s, int e) {
            this.start = s;
            this.end = e;
        }
        // 시작 시간 기준으로 정렬
        @Override
        public int compareTo(Lecture o) {
            return this.start - o.start; 
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수업 개수 

        Lecture[] lectures = new Lecture[N]; // 수업 정보 저장 

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(s, t);
        }

        Arrays.sort(lectures); // 시작 시간을 기준으로 정렬 (우선순위 큐 사용하기)

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 가장 빨리 끝나는 수업의 종료 시간

        pq.add(lectures[0].end); //첫 번째 수업은 무조건 강의실 하나 필요함 

        for (int i = 1; i < N; i++) {
            // 가장 빨리 끝나는 강의보다 현재 강의 시작이 늦거나 같으면 강의실 재사용 가능
            if (lectures[i].start >= pq.peek()) {
                pq.poll(); 
            }
            pq.add(lectures[i].end); // 강의실 사용
        }

        System.out.println(pq.size()); 
    }
}
