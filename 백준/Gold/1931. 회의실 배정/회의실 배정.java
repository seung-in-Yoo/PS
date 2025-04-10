import java.io.*;
import java.util.*;

// 가장 빨리 끝나는 시간 선택하는 그리디 문제 
// 문제 은근 까다롭네,,, 나중에 다시 한번 더 풀어보기
public class Main {
    public static void main(String[] args) throws IOException {
        // Scanner 대신 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] meeting = new int[N][2]; // 회의 정보 저장 배열 (2차원으로)

        for (int i = 0; i < N; i++) {
            // 한 줄에 두 개의 정수가 들어오니 StringTokenizer 사용 
            StringTokenizer st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            meeting[i][1] = Integer.parseInt(st.nextToken()); // 끝나는 시간
        }
        
        // 회의를 끝나는 시간을 기준으로 정렬
        Arrays.sort(meeting, (a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]); // 끝나는 시간이 같을 경우 시작 시간 비교
            return Integer.compare(a[1], b[1]);
        });

        int count = 0;
        int endTime = 0;
        
        // 그리디로 선택 
        for (int i = 0; i < N; i++) {
            if (meeting[i][0] >= endTime) {
                count++;
                endTime = meeting[i][1];
            }
        }

        System.out.println(count);
    }
}
