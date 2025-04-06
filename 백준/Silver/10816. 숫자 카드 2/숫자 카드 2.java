import java.util.*;

// 배열로 정렬해놓고 숫자가 배열안에 몇개 들어있는지 찾는 문제 (이진 탐색 사용)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] A = new int[N]; // 상근이가 가지고 있는 숫자 카드의 배열
        
        for (int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        
        Arrays.sort(A);
        
        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            int lower = lowerPosition(A, target);
            int upper = upperPosition(A, target);
            sb.append(upper - lower).append(" ");
        }

        System.out.println(sb);
    }
    
    // 원하는 숫자가 처음 나오는 함수
    static int lowerPosition(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        
        while(left < right) {
            int mid = (left+right) / 2;
            if (arr[mid] < target) {
                left = mid + 1; // 내가 원하는 타겟인 숫자보다 작으면 왼쪽 버림 
            } else {
                right = mid; // 같거나 크면 유지 
            }
        }
        
        return left;
    } 
     
     // 아까 나온 숫자에서 다른 초과하는 값이 처음 나오는 함수 
     static int upperPosition(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left+right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1; // 내가 원하는 타겟 숫자보다 같으면 오른쪽으로 이동 
            } else {
                right = mid;
            }
        }

        return left;
    }
}