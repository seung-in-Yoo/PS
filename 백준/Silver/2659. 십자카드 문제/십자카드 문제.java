import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] nums = new int[4]; // 4개 숫자 입력받기 위해 배열 생성 후 for문으로 입력받기
        for (int i = 0; i < 4; i++) {
            nums[i] = scanner.nextInt();
        }

        int clockNumber = getClockNumber(nums);

        Set<Integer> clockNumbers = new TreeSet<>(); // 중복을 허용하지 않고 정렬을 위해 TreeSet 사용

        // 1111부터 9999까지 가능한 모든 시계수 구하기 (완전 탐색)
        for (int num = 1111; num <= 9999; num++) {
            int[] clockNums = { num / 1000, (num / 100) % 10, (num / 10) % 10, num % 10 };

            // 0이 포함되면 제외하기 
            if (clockNums[0] == 0 || clockNums[1] == 0 || clockNums[2] == 0 || clockNums[3] == 0) {
                continue;
            }
            clockNumbers.add(getClockNumber(clockNums));
        }

        // TreeSet을 리스트로 변환 후 현재 시계수의 순위 찾기
        List<Integer> sortedClock = new ArrayList<>(clockNumbers);
        int clockRank = sortedClock.indexOf(clockNumber) + 1; 

        System.out.println(clockRank);
    }

    // 주어진 4자리 숫자 배열의 시계수를 구하는 함수
    private static int getClockNumber(int[] num) {
        int minClockNum = Integer.MAX_VALUE; 
        // 4가지 회전된 숫자 중 최소값 찾기
        for (int i = 0; i < 4; i++) {
            // 인덱스 크기를 넘어가지 않도록 % 4 해줘야 함
            int numRotated = num[i] * 1000 + num[(i + 1) % 4] * 100 + num[(i + 2) % 4] * 10 + num[(i + 3) % 4];
            minClockNum = Math.min(minClockNum, numRotated); 
        }

        return minClockNum;
    }
}

