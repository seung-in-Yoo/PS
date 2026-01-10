import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int xHole, yHole;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class State {
        int rx, ry, bx, by, count;
        State(int rx, int ry, int bx, int by, int count) {
            this.rx = rx; this.ry = ry;
            this.bx = bx; this.by = by;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i; ry = j;
                    board[i][j] = '.';
                }
                if (board[i][j] == 'B') {
                    bx = i; by = j;
                    board[i][j] = '.';
                }
                if (board[i][j] == 'O') {
                    xHole = i; yHole = j;
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<State> q = new LinkedList<>();
        q.add(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            State current = q.poll();

            for (int d = 0; d < 4; d++) {
                int[] rMove = move(current.rx, current.ry, d);
                int[] bMove = move(current.bx, current.by, d);

                int nrx = rMove[0], nry = rMove[1], rCount = rMove[2];
                int nbx = bMove[0], nby = bMove[1], bCount = bMove[2];

                // 파란 구슬 빠지면 실패
                if (nbx == xHole && nby == yHole) {continue;}

                // 빨간 구슬만 빠지면 성공
                if (nrx == xHole && nry == yHole) {
                    return current.count + 1;
                }

                // 둘이 같은 칸이면 조정하기
                if (nrx == nbx && nry == nby) {
                    if (rCount > bCount) {
                        nrx -= dr[d];
                        nry -= dc[d];
                    } else {
                        nbx -= dr[d];
                        nby -= dc[d];
                    }
                }

                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    q.add(new State(nrx, nry, nbx, nby, current.count + 1));
                }
            }
        }
        return -1;
    }

    static int[] move(int x, int y, int d) {
        int count = 0;
        while (true) {
            int nx = x + dr[d];
            int ny = y + dc[d];
            if (board[nx][ny] == '#') { break; }
            x = nx; y = ny;
            count++;
            if (x == xHole && y == yHole) { break; }
        }
        return new int[]{x, y, count};
    }
}
