import java.io.*;
import java.util.*;

public class Main {

    static int M, N, K;                 // 가로,세로,배추 개수
    static int[][] field;               // 배추밭 배열로 정의
    static boolean[][] visited;         
    // 행,열 이동 관련 정의 
    static int[] dr = {-1, 1, 0, 0};    
    static int[] dc = {0, 0, -1, 1};   

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());                 

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());                
            N = Integer.parseInt(st.nextToken());               
            K = Integer.parseInt(st.nextToken());                
            field = new int[N][M];                               
            visited = new boolean[N][M];                         
            for (int i = 0; i < K; i++) {                        
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());        
                int y = Integer.parseInt(st.nextToken());        
                field[y][x] = 1;                                 
            }
            int worms = 0;  // 지렁이 수 
            // 모든 칸 탐색 
            for (int r = 0; r < N; r++) {                        
                for (int c = 0; c < M; c++) {                    
                    if (field[r][c] == 1 && !visited[r][c]) {    
                        worms++;                                 
                        bfs(r, c);                              
                    }
                }
            }
            sb.append(worms).append('\n');                       
        }
        System.out.print(sb);                                    
    }
    // bfs 구현 
    static void bfs(int sr, int sc) {
        Queue<int[]> q = new ArrayDeque<>(); // 큐 정의                  
        q.offer(new int[]{sr, sc});                             
        visited[sr][sc] = true;                                 

        while (!q.isEmpty()) {
            int[] current = q.poll();                                
            int r = current[0];                                     
            int c = current[1];                                      
            // 상,하,좌,우 방향 확인 
            for (int d = 0; d < 4; d++) {                       
                int nr = r + dr[d];                              
                int nc = c + dc[d];                              
                // 범위 벗어나면 제외 
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {      
                    continue;
                }
                // 배추 없으면 제외 
                if (field[nr][nc] == 0) {                         
                    continue;
                }
                // 이미 방문 제외 
                if (visited[nr][nc]) {                            
                    continue;
                }
                visited[nr][nc] = true; // 방문 처리                         
                q.offer(new int[]{nr, nc});                      
            }
        }
    }
}
