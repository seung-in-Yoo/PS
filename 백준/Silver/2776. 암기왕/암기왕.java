import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt(); // 테스트 케이스 

        while (T-- > 0) {
            int N = sc.nextInt(); // 수첩에 적은 정수의 개수
            int[] see = new int[N]; 
            for (int i = 0; i < N; i++) {
                see[i] = sc.nextInt();
            }

            Arrays.sort(see); 

            int M = sc.nextInt(); // 물어본 정수의 개수
            StringBuilder sb = new StringBuilder(); 

            for (int i = 0; i < M; i++) {
                int question = sc.nextInt(); // 물어본 정수들 
                // 이진 탐색 사용
                if (Arrays.binarySearch(see, question) >= 0) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }

            System.out.print(sb.toString());
        }
    }
}
