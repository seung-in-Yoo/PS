import java.util.*;

// 유형 -> 이진 탐색
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); 
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt(); 
        }

        Arrays.sort(A); // 이진 탐색을 위해서 정렬하기 

        int M = sc.nextInt(); 
        StringBuilder sb = new StringBuilder(); // 문자열 저장 

        for (int i = 0; i < M; i++) {
            int num = sc.nextInt(); // 확인할 숫자
            if (binarySearch(A, num)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.print(sb); // 결과 출력
    }

    // 이진 탐색 함수 구현 (많이 쓰기때문에 코드 외워도 될듯)
    private static boolean binarySearch(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
