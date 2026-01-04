import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i=0; i<N; i++) {
            String line = sc.next();
            for (int j=0; j<N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        
        ArrayList<Integer> buildings = new ArrayList<>();
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int count = bfs(i,j);
                    buildings.add(count);
                }
            }
        }
        Collections.sort(buildings);
        System.out.println(buildings.size());
        for (int c : buildings) {
            System.out.println(c);
        }
    }
    
    static int bfs(int sr, int sc) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        visited[sr][sc] = true;
        
        int count = 1;
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            
            for (int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if (nr<0 || nc<0 || nr>=N || nc>=N) { continue; }
                
                if (map[nr][nc] == 0) { continue; }
                
                if (visited[nr][nc] == true) { continue; }
                
                visited[nr][nc] = true;
                count++;
                q.add(new int[]{nr,nc});
            }
        }
        return count;
    }
}