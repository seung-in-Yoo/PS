import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] visitOrder;
    static boolean[] visited;
    static int order = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정점 
        int m = sc.nextInt(); // 간선 
        int r = sc.nextInt(); // 시작 정점

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        // 각 노드의 인접 정점들 오름차순으로 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        // 방문 순서 저장
        visitOrder = new int[n + 1];
        visited = new boolean[n + 1];

        bfs(r);
        
        for (int i = 1; i <= n; i++) {
            System.out.println(visitOrder[i]);
        }
    }
    
    // bfs 구현 
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        visitOrder[start] = order++;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    visitOrder[next] = order++;
                    q.add(next);
                }
            }
        }
    }
}
