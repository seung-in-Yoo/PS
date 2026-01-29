import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int answer = Integer.MAX_VALUE;

        // 완전 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                answer = Math.min(answer, repaintCount(i, j));
            }
        }

        System.out.println(answer);
    }

    static int repaintCount(int x, int y) {
        int countWhite = 0; 
        int countBlack = 0; 

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char current = board[x + i][y + j];

                if ((i + j) % 2 == 0) {
                    if (current != 'W') countWhite++;
                    if (current != 'B') countBlack++;
                } else {
                    if (current != 'B') countWhite++;
                    if (current != 'W') countBlack++;
                }
            }
        }

        return Math.min(countWhite, countBlack);
    }
}
