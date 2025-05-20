import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();         // 학생 수
        scanner.nextLine();               

        String[] studentNumbers = new String[N];
            
        for (int i = 0; i < N; i++) {
            studentNumbers[i] = scanner.nextLine(); // 학생 번호 입력받기
        }

        int length = studentNumbers[0].length(); // 학생 번호 길이

        
        for (int k = 1; k <= length; k++) {
            if (leastDigit(studentNumbers, k)) {
                System.out.println(k);
                return;
            }
        }
    }

    // 가능한 최소 자리 (중복 X) 판별 함수 구현 
    private static boolean leastDigit(String[] numbers, int k) {
        Set<String> seen = new HashSet<>();

        for (String number : numbers) {
            String lastDigit = number.substring(number.length() - k);  // 뒤에서 k자리 추출

            if (!seen.add(lastDigit)) {
                return false;
            }
        }

        return true;
    }
}
