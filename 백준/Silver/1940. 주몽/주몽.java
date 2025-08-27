import java.io.*;
import java.util.*;

// 정렬 + 투포인터 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 재료 번호 정렬 

        int left = 0, right = N - 1; // 가장 왼쪽과 오른쪽 
        int answer = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == M) {
                answer++;
                left++;
                right--;
            } else if (sum < M) { // 값이 작으면 왼쪽 (가장 작은 값)을 늘림
                left++;
            } else { // 값이 크면 오른쪽 (가장 큰 값)을 줄임
                right--;
            }
        }

        System.out.println(answer);
    }
}