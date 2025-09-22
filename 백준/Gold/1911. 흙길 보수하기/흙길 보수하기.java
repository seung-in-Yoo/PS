import java.io.*;
import java.util.*;

public class Main {
    
    // 물 웅덩이 객체로 만들기 
    static class Puddle implements Comparable<Puddle> {
        int start, end;

        public Puddle(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Puddle other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 웅덩이 수
        int L = Integer.parseInt(st.nextToken()); // 널빤지 길이

        Puddle[] puddles = new Puddle[N]; // 물 웅덩이 있는 곳 

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            puddles[i] = new Puddle(start, end);
        }

        Arrays.sort(puddles); // 정렬 진행 

        int answer = 0;
        int plankEnd = 0; // 마지막으로 널빤지를 덮은 위치

        for (int i = 0; i < N; i++) {
            int start = puddles[i].start;
            int end = puddles[i].end;

            // 이미 덮은 부분이면 시작점
            if (plankEnd > start) {
                start = plankEnd;
            }

            // 아직 물웅덩이를 덮지 않았다면 계산 
            if (start < end) {
                int length = end - start;
                int count = (length + L - 1) / L; 
                answer += count;
                plankEnd = start + count * L; 
            }
        }

        System.out.println(answer);
    }
}
