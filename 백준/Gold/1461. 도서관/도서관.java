import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 책 개수
        int M = Integer.parseInt(st.nextToken()); // 한 번에 들 수 있는 책 수

        st = new StringTokenizer(br.readLine());
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int pos = Integer.parseInt(st.nextToken());
            if (pos > 0) { plus.add(pos); }
            else { minus.add(-pos); } // 음수는 절댓값으로 변환
        }

        // 내림차순 정렬 
        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus, Collections.reverseOrder());

        int maxDistance = 0; // 마지막에 빼줄 최대 거리
        if (!plus.isEmpty()) { maxDistance = Math.max(maxDistance, plus.get(0)); }
        
        if (!minus.isEmpty()) { maxDistance = Math.max(maxDistance, minus.get(0));}

        long total = 0;

        // 양수 처리 
        for (int i = 0; i < plus.size(); i += M) {
            total += plus.get(i) * 2L;
        }

        // 음수 처리
        for (int i = 0; i < minus.size(); i += M) {
            total += minus.get(i) * 2L;
        }

       
        total -= maxDistance;

        System.out.println(total);
    }
}