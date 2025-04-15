import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine()); // 수의 개수

        int[] arr = new int[N]; // 입력된 수 저장
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        // 산술 평균 -> 반올림 해야함 
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        int avg = (int) Math.round((double) sum / N);

        // 중앙값 -> 정렬 후 가운데 값 출력 
        Arrays.sort(arr);
        int median = arr[N / 2];

        // 최빈값 계산 -> 빈도 배열 채워야함 
        int[] freq = new int[8001]; 
        for (int i = 0; i < N; i++) {
            freq[arr[i] + 4000]++;
        }

        int maxFreq = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i]; // 가장 높은 빈도 수 찾기 
            }
        }
 
        ArrayList<Integer> modes = new ArrayList<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == maxFreq) {
                modes.add(i - 4000); // 인덱스 다시 복원 
            }
        }

        // 두 번째로 작은 최빈값 선택하기
        int mode = modes.size() >= 2 ? modes.get(1) : modes.get(0);

        
        int range = arr[N - 1] - arr[0];

        System.out.println(avg); // 평균
        System.out.println(median); // 중앙값
        System.out.println(mode); // 최빈값 (여러개면 두번째로 작은 값)
        System.out.println(range); // 범위 
    }
}
