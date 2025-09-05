import java.io.*;
import java.util.*;

public class Main {
    
    // 좌표, 현재 높이 저장 
    static class Cell implements Comparable<Cell> {
        int x, y, height;

        public Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
        
        // 우선순위 큐에서 낮은것부터 처리 
        public int compareTo(Cell other) {
            return this.height - other.height;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][] visited; // 방문 체크용 배열 
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        
        // 지도 높이 
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(trapWater());
    }
    
    // 물이 고일수 있는 총량을 구함 
    static int trapWater() {
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        
        
        for (int i = 0; i < N; i++) {
            pq.add(new Cell(i, 0, map[i][0]));
            pq.add(new Cell(i, M - 1, map[i][M - 1]));
            visited[i][0] = true;
            visited[i][M - 1] = true;
        }

        for (int j = 1; j < M - 1; j++) {
            pq.add(new Cell(0, j, map[0][j]));
            pq.add(new Cell(N - 1, j, map[N - 1][j]));
            visited[0][j] = true;
            visited[N - 1][j] = true;
        }

        int water = 0;
        
        // BFS로 구하기 + 낮은곳부터 구하기 
        while (!pq.isEmpty()) {
            Cell current = pq.poll();

            for (int d = 0; d < 4; d++) {
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];
                
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) { continue; }
                visited[nx][ny] = true;

                // 현재 셀의 높이보다 낮다면 물 채움 
                if (map[nx][ny] < current.height) {
                    water += current.height - map[nx][ny];
                }

                pq.add(new Cell(nx, ny, Math.max(map[nx][ny], current.height)));
            }
        }

        return water;
    }
}