import java.io.*;              
import java.util.*;            

public class Main {

    static List<Integer>[] graph; // 그래프 인접 리스트
    static boolean[] visited;     // 방문 체크
    static int infected = 0;      // 감염된 컴퓨터 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        int n = Integer.parseInt(br.readLine());  // 컴퓨터 개수
        int m = Integer.parseInt(br.readLine());  // 간선 개수

        graph = new ArrayList[n + 1];            
        visited = new boolean[n + 1];             

        for (int i = 1; i <= n; i++) {           
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {             
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 
            graph[a].add(b);                      
            graph[b].add(a);                      
        }
        dfs(1);                                   // 1번 컴퓨터에서 DFS 시작
        System.out.println(infected);             
    }
    
    // 현재 컴퓨터에서 DFS 탐색하기 
    static void dfs(int current) {                   
        visited[current] = true;                      
        // 전체 탐색 
        for (int next : graph[current]) {             
            if (!visited[next]) {                 
                infected++;                       
                dfs(next);                       
            }
        }
    }
}
