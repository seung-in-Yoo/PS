import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 과일 개수
        int L = sc.nextInt(); // 초기 길이

        int[] fruit = new int[N];
        for (int i = 0; i < N; i++) {
            fruit[i] = sc.nextInt(); // 과일 높이 입력
        }

        Arrays.sort(fruit); // 과일들 높이별로 정렬 

        for (int i = 0; i < N; i++) {
            if (fruit[i] <= L) {
                L++; 
            } else {
                break; 
            }
        }

        System.out.println(L); 
    }
}