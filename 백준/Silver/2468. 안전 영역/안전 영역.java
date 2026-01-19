import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] height;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        height = new int[N][N];
        int maxHeight = 0; // 0부터 시작
        
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                height[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, height[i][j]);
            }
        }
        
        int answer = 1; 
        
        for (int h=0; h<maxHeight; h++) {
            visited = new boolean[N][N];
            int count = 0;
            
            for (int r=0; r<N; r++) {
                for (int c=0; c<N; c++) {
                    if (height[r][c] > h && !visited[r][c]) {
                        bfs(r,c,h);
                        count++;
                    }
                }
            }
            answer = Math.max(answer,count);
        }
        System.out.println(answer);
    }
    
    static void bfs(int sr, int sc, int h) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        visited[sr][sc] = true;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            
            for (int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if (nr<0 || nc<0 || nr>=N || nc>=N) {continue;}
                
                if (visited[nr][nc]) {continue;}
                
                if (height[nr][nc] <= h) {continue;}
                
                visited[nr][nc] = true;
                q.add(new int[]{nr,nc});
            }
        }
    }
}