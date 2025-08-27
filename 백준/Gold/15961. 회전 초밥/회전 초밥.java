import java.io.*;
import java.util.*;

// 슬라이딩 윈도우 + 해시/카운팅
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int d = Integer.parseInt(st.nextToken()); 
        int k = Integer.parseInt(st.nextToken()); 
        int c = Integer.parseInt(st.nextToken()); 

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1]; 
        int kind = 0;

        // 초기 윈도우 세팅 
        for (int i = 0; i < k; i++) {
            if (count[belt[i]] == 0) { kind++; }
            count[belt[i]]++;
        }

        int answer = kind;
        // 쿠폰 처리
        if (count[c] == 0) { answer++; }

        // 슬라이딩 윈도우 시작 
        for (int i = 1; i < N; i++) {
            // 나가는 초밥
            int remove = belt[i - 1];
            
            count[remove]--;
            
            if (count[remove] == 0) { kind--; }

            // 들어오는 초밥 (원형 처리 해줘야함)
            int add = belt[(i + k - 1) % N];
            
            if (count[add] == 0) { kind++; }
            
            count[add]++;

            // 현재 종류 + 쿠폰 
            int current = kind; // 현재 
            
            if (count[c] == 0) { current++; }
            
            answer = Math.max(answer, current); // 이전에 answer와 현재 중에 최대값 선택 
        }

        System.out.println(answer);
    }
}