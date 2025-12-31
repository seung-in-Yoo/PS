import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dr = {-1, 0, 0, 1}; 
    static int[] dc = {0, -1, 1, 0};

    static class Position {
        int r, c;
        Position(int r, int c) { this.r = r; this.c = c; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int sr = -1, sc = -1; // 상어 시작 위치

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {         
                    sr = i;
                    sc = j;
                    map[i][j] = 0; // 상어 있는 칸은 빈 칸으로 처리
                }
            }
        }
        int sharkSize = 2;   // 초기 크기 설정 
        int eatCount = 0;    // 현재 크기에서 먹은 횟수
        int time = 0;        // 총 이동 시간

        while (true) {
            int[][] distance = bfs(sr, sc, sharkSize); // 현재 위치에서 최단거리 계산
            int bestDist = Integer.MAX_VALUE;
            int bestR = -1, bestC = -1;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (distance[r][c] == -1) continue;               
                    if (map[r][c] == 0) continue;                
                    if (map[r][c] >= sharkSize) continue;         
                    int d = distance[r][c];

                    // 거리 더 짧으면 갱신
                    if (d < bestDist) {
                        bestDist = d;
                        bestR = r;
                        bestC = c;
                    }
                    else if (d == bestDist) {
                        if (r < bestR || (r == bestR && c < bestC)) {
                            bestR = r;
                            bestC = c;
                        }
                    }
                }
            }

            // 더 이상 먹을 물고기 없으면 종료
            if (bestR == -1) { break; }

            // 물고기 먹으러 이동하기
            time += bestDist;
            sr = bestR;
            sc = bestC;
            map[sr][sc] = 0; // 먹었으면 빈칸으로 백       
            eatCount++;           
            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(time);
    }

    // 상어 크기를 기준으로 이동 가능한 칸만 BFS로 구현 
    static int[][] bfs(int sr, int sc, int sharkSize) {
        int[][] distance = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(distance[i], -1);

        ArrayDeque<Position> q = new ArrayDeque<>();
        q.offer(new Position(sr, sc));
        distance[sr][sc] = 0;

        while (!q.isEmpty()) {
            Position cur = q.poll();
            int r = cur.r, c = cur.c;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                    continue;
                }
                if (distance[nr][nc] != -1) {
                    continue; 
                }
                if (map[nr][nc] > sharkSize) {
                    continue;
                }
                distance[nr][nc] = distance[r][c] + 1;
                q.offer(new Position(nr, nc));
            }
        }

        return distance;
    }
}
