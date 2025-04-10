import java.util.*;

// 이진 탐색 문제 
// 집의 좌표를 정렬후에 공유기의 설치 간격을 이진탐색하기 현재 거리로 공유기를 설치할 수 있는지 확인
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 집의 개수
        int C = sc.nextInt(); // 공유기의 개수

        int[] house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = sc.nextInt();
        }

        Arrays.sort(house); // 집의 위치 정렬
        
        // 이진 탐색 부분 시작 
        int left = 1; // 최소 거리 
        int right = house[N - 1] - house[0]; // 가능한 최대 거리
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canInstall(house, C, mid)) {
                result = mid; // 설치 가능 → 더 넓은 거리 시도
                left = mid + 1;
            } else {
                right = mid - 1; // 설치 불가 → 거리 좁히기
            }
        }

        System.out.println(result);
    }

    // 공유기를 주어진 거리로 설치 가능한지 확인하는 함수
    public static boolean canInstall(int[] house, int C, int distance) {
        int count = 1; // 첫 집에는 무조건 설치
        int installed = house[0];

        for (int i = 1; i < house.length; i++) {
            if (house[i] - installed >= distance) {
                count++;
                installed = house[i];
            }
        }

        return count >= C;
    }
}