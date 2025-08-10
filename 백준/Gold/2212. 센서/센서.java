import java.util.*;

// 전형적인 그리디 알고리즘 유형 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] sensor = new int[N];

        for (int i = 0; i < N; i++) {
            sensor[i] = sc.nextInt();
        }

        if (K >= N) {
            System.out.println(0);
            return;
        }

        Arrays.sort(sensor); // 센서 좌표 정렬 

        int[] interval = new int[N - 1]; // 센서 간의 간격 저장 배열 
        for (int i = 0; i < N - 1; i++) {
            interval[i] = sensor[i + 1] - sensor[i]; // 인접거리 계산 
        }

        Arrays.sort(interval); // 다시 센서 간 간격 정렬 (큰 거리순)

        int sum = 0;
        for (int i = 0; i < N - K; i++) {
            sum += interval[i];
        }

        System.out.println(sum);
    }
}