import java.util.*;
import java.io.*;

public class Main {
    static int N, M, R;
    static ArrayList<Integer>[] graph;
    static int[] order; 
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        // 인접 정점 내림차순 정렬
        for (int i = 1; i <= N; i++) {
            graph[i].sort(Comparator.reverseOrder());
        }

        order = new int[N+1];
        visited = new boolean[N+1];

        bfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.print(sb);
    }
    
    // bfs 구현 
    static void bfs(int start) {
        Queue<Integer> Q = new LinkedList<>();
        visited[start] = true;
        Q.add(start);

        int seqence = 1;
        order[start] = seqence++;

        while (!Q.isEmpty()) {
            int now = Q.poll();

            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    order[next] = seqence++;
                    Q.add(next);
                }
            }
        }
    }
}
