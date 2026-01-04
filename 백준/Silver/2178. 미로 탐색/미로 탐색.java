import java.util.*;

public class Main {
    static int N,M;
    static int[][] maze;
    static int[][] distance;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        maze = new int[N][M];
        distance = new int[N][M];
        
        for (int i=0; i<N; i++) {
            String line = sc.next();
            for (int j=0; j<M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }
        
        bfs(0,0);
        System.out.println(distance[N-1][M-1]);
    }
    
    static void bfs(int sr, int sc) {
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{sr,sc});
        distance[sr][sc] = 1; // 시작 칸도 칸수에 포함시켜야함
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            
            // 상하좌우 확인
            for (int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if (nr<0 || nc<0 || nr>=N || nc>=M) { continue; } // 범위 밖
                
                if (maze[nr][nc] == 0) { continue; } // 벽 제외
                
                if (distance[nr][nc] != 0) { continue; } // 이미 방문
                
                distance[nr][nc] = distance[r][c] + 1;
                
                q.add(new int[] {nr,nc});
            }
        }
    }
}