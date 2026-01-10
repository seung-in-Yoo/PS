import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] paper;
    static boolean[][] visited;
    
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        paper = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int count = 0;
        int maxArea = 0;
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                // 1인데 아직 방문 안한 경우
                if (paper[i][j] == 1 && !visited[i][j]) {
                    count++;
                    int area = bfs(i,j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        System.out.println(count);
        System.out.println(maxArea);
    }
    
    static int bfs(int sr, int sc) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        visited[sr][sc] = true;
        
        int area = 1;
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
               
            for (int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if (nr<0 || nc<0 || nr>=n || nc>= m) {continue;}
                
                if (paper[nr][nc] == 0) {continue;}
                
                if (visited[nr][nc]) {continue;}
                
                visited[nr][nc] = true;
                area++;
                q.add(new int[]{nr,nc});
            }
        }
        
        return area;
    }
}