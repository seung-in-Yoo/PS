import java.util.*;

public class Main {
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        int M = sc.nextInt(); 

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int count = 0;

        // 첫번째 for: 아래 => 위, 두번째 for: 오른쪽 => 왼쪽
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (map[i][j] == 1) {
                    flip(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
    
    // 뒤집기 함수 
    static void flip(int r, int c) {
        for (int i = 0; i <= r; i++) {
            for (int j = 0; j <= c; j++) {
                map[i][j] = 1 - map[i][j]; // 0이면 1, 1이면 0
            }
        }
    }
}
