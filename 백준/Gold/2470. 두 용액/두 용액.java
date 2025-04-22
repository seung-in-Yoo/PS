import java.util.*;

// 투포인터 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 용액 개수
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); 

        int left = 0;
        int right = N - 1;

        int minSum = Integer.MAX_VALUE; // 가장 0에 가까운 합의 절댓값
        int answer1 = 0;
        int answer2 = 0;

        // 투 포인터 구현 
        while (left < right) {
            int sum = arr[left] + arr[right]; // 두 수의 합

            // 현재 합이 0에 더 가까운 경우 저장
            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                answer1 = arr[left];
                answer2 = arr[right];

                if (minSum == 0) break; 
            }

            // 합이 음수면 왼쪽이 증가, 양수면 오른쪽 감소
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        if (answer1 < answer2) {
            System.out.println(answer1 + " " + answer2);
        } else {
            System.out.println(answer2 + " " + answer1);
        }
    }
}
