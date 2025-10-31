import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] clean;

    static int[] dy = {-1, 0, 1, 0}; 
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        int y = sc.nextInt();
        int x = sc.nextInt();
        int d = sc.nextInt(); 

        map = new int[N][M];
        clean = new boolean[N][M];

        for (int i = 0; i < N; i++) 
            for (int j = 0; j < M; j++) 
                map[i][j] = sc.nextInt();

        int result = 0;

        while (true) {
            if (!clean[y][x]) {
                clean[y][x] = true;
                result++;
            }

            boolean found = false;
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; 
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (map[ny][nx] == 0 && !clean[ny][nx]) {
                        y = ny;
                        x = nx;
                        found = true;
                        break;
                    }
                }
            }

            if (found) { continue; }

            int back = (d + 2) % 4;
            int by = y + dy[back];
            int bx = x + dx[back];

            if (by >= 0 && by < N && bx >= 0 && bx < M && map[by][bx] != 1) {
                y = by;
                x = bx;
            } else {
                break;
            }
        }

        System.out.println(result);
    }
}
