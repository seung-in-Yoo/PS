import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[][] paper = new boolean[100][100]; // 도화지 크기
        int N = sc.nextInt(); // 색종이 개수

        for (int n = 0; n < N; n++) {
            int x = sc.nextInt(); // 색종이 x좌표
            int y = sc.nextInt(); // 색종이 y좌표

            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    paper[i][j] = true;
                }
            }
        }

        int area = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j]) {
                    area++;
                }
            }
        }

        System.out.println(area);
    }
}
