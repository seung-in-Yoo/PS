import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 투포인터 구현 시작 
        int left = 0;
        int right = N - 1;
        int answer = arr[left] + arr[right]; // 초기값

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < Math.abs(answer)) {
                answer = sum;
            }

            // 조건에 따라 포인터 이동 
            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else { 
                answer = 0;
                break;
            }
        }

        System.out.println(answer);
    }
}