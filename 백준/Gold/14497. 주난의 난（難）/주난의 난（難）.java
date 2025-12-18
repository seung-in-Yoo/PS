import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[][] distance;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken()) - 1;
        int sy = Integer.parseInt(st.nextToken()) - 1;
        int ex = Integer.parseInt(st.nextToken()) - 1;
        int ey = Integer.parseInt(st.nextToken()) - 1;

        map = new char[N][M];
        
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        distance = new int[N][M];
        
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{sx, sy});
        distance[sx][sy] = 0;

        while (!dq.isEmpty()) {
            int[] current = dq.poll();
            int x = current[0], y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x;
                int ny = y;

                while (true) {
                    nx += dx[d];
                    ny += dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        break;
                    }

                    if (map[nx][ny] == '1') {
                        if (distance[nx][ny] > distance[x][y] + 1) {
                            distance[nx][ny] = distance[x][y] + 1;
                            dq.addLast(new int[]{nx, ny});
                        }
                        break;
                    }

                    if (distance[nx][ny] > distance[x][y]) {
                        distance[nx][ny] = distance[x][y];
                        dq.addFirst(new int[]{nx, ny});
                    }

                    if (map[nx][ny] == '#') {
                        System.out.println(distance[nx][ny] + 1);
                        return;
                    }
                }
            }
        }
    }
}
