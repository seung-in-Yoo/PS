import java.util.*;

//유형 -> 그리디 알고리즘
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 원생의 수
        int K = sc.nextInt(); // 조의 개수
        int[] heights = new int[N];

        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }

        
        int[] stuDiff = new int[N - 1]; 
        for (int i = 0; i < N - 1; i++) {
            stuDiff[i] = heights[i + 1] - heights[i]; // 인접한 학생들 사이의 키 차이를 배열로 저장
        }

        Arrays.sort(stuDiff); // 키 차이가 작은것부터 앞으로 오도록 정렬 
        
        int result = 0;
        
        for (int i = 0; i < N - K; i++) {
            result += stuDiff[i];
        }

        System.out.println(result);
    }
}