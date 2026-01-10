import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static char[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new char[n][m];
        
        for (int i=0; i<n; i++) {
            String line = br.readLine();
            for (int j=0; j<m; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        
        int answer = 0;
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] == 'L') {
                    int far = bfs(i,j);
                    answer = Math.max(answer, far);
                }
            }
        }
        
        System.out.println(answer);
    }
    
    static int bfs(int sr, int sc) {
        int[][] distance = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        distance[sr][sc] = 1;
        int maxDistance = 0;
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            maxDistance = Math.max(maxDistance, distance[r][c]-1);
            
            for (int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if (nr<0 || nc<0 || nr>=n || nc>=m) {continue;}
                
                if (map[nr][nc] == 'W') {continue;}
                
                if (distance[nr][nc] != 0) {continue;}
                
                distance[nr][nc] = distance[r][c] + 1;
                q.add(new int[]{nr,nc});
               
            }
        }
        
        return maxDistance;
    }
}