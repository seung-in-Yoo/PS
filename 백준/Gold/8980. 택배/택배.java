import java.io.*;
import java.util.*;

public class Main {
    static class Box {
        int from, to, count;
        Box(int from, int to, int count) {
            this.from = from;
            this.to = to;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        Box[] boxes = new Box[M];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            boxes[i] = new Box(from, to, cnt);
        }
        // 도착 마을 기준으로 정렬
        Arrays.sort(boxes, (a, b) -> {
            if (a.to != b.to) { return a.to - b.to; }
            return a.from - b.from;
        });
        // 구간별 사용 용량
        int[] used = new int[N + 1]; 
        int answer = 0;

        for (Box box : boxes) {
            int maxUsed = 0;
            // from ~ to 구간 중 가장 많이 찬 구간
            for (int i=box.from; i<box.to; i++) {
                maxUsed = Math.max(maxUsed, used[i]);
            }
            int load = Math.min(box.count, C - maxUsed);
            if (load <= 0) { continue; }
            for (int i = box.from; i < box.to; i++) {
                used[i] += load;
            }
            answer += load;
        }
        System.out.println(answer);
    }
}
