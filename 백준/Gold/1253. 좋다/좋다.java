import java.util.*;

// 투포인터 문제 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A); 

        int count = 0;

        // 각 숫자를 기준으로 잡고 나머지 두 수의 합으로 만들 수 있는지 투포인터로 확인
        for (int k = 0; k < N; k++) {
            int target = A[k]; // 현재 좋은 수인지 확인할 타겟 
            int left = 0;
            int right = N - 1;

            while (left < right) {
                if (left == k) {
                    left++;
                    continue; 
                }
                if (right == k) {
                    right--;
                    continue; 
                }

                int sum = A[left] + A[right];

                if (sum == target) {
                    count++;
                    break; // 좋은 수이므로 끝내기 
                } else if (sum < target) {
                    left++; // 합이 작으면 오른쪽으로 이동
                } else {
                    right--; // 합이 크면 왼쪽으로 이동
                }
            }
        }

        System.out.println(count);
    }
}
