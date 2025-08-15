import java.io.*;
import java.util.*;

public class Main {
    static class Line implements Comparable<Line> {
        int start, end;
        Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Line o) {
            if (this.start == o.start) { return this.end - o.end; }
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Line> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Line(x, y));
        }

        
        Collections.sort(list); // 사각점 기준으로 해서 정렬 

        long total = 0;
        int goStart = list.get(0).start;
        int goEnd = list.get(0).end;

        // 병합을 통해서 병합 하면서 길이 계산
        for (int i = 1; i < N; i++) {
            Line now = list.get(i);
            if (now.start <= goEnd) { // 겹치는 경우
                goEnd = Math.max(goEnd, now.end);
            } else { // 겹치지 않는 경우 
                total += (goEnd - goStart);
                goStart = now.start;
                goEnd = now.end;
            }
        }

        total += (goEnd - goStart); 

        System.out.println(total);
    }
}