import java.io.*;
import java.util.*;

// 전형적인 그리디 문제
// 정렬한 후 차례대로 추의 무게를 보면서 측정 가능한 범위를 늘리다가 끊기는 지점을 찾기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] weights = new int[N];
        
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(weights); // 추 무게 정렬 
        
        long range = 0; 
        
        for (int w : weights) {
            if (w > range + 1) {
                break; 
            }
            range += w;
        }
        
        System.out.println(range + 1);
    }
}