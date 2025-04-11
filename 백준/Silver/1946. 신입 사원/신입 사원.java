import java.io.*;
import java.util.*;

// 그리디,이진탐색
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력해야할게 많아서 buffer사용
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 지원자 수 입력
            int[][] personTotalScore = new int[N][2]; // [서류, 면접]

            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()); // 입력 값 나눠서 처리
                personTotalScore[i][0] = Integer.parseInt(st.nextToken()); // 서류 성적
                personTotalScore[i][1] = Integer.parseInt(st.nextToken()); // 면접 성적
            }
          
            Arrays.sort(personTotalScore, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[0], b[0]);  // 서류 성적 기준 오름차순 정렬하기
                }
            });
            
            // 이진 탐색 관련 
            int count = 1; 
            int mid = personTotalScore[0][1]; 

            for (int i = 1; i < N; i++) {
                if (personTotalScore[i][1] < mid) {
                    count++;
                    mid = personTotalScore[i][1]; 
                }
            }
            System.out.println(count);
        }
    }
}
