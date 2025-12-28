import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static List<Integer>[] graph; // 인접 그래프 
    static int[] order; // 각 정점의 방문 순서(방문 안 하면 0)
    static int count = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1]; // 그래프에서 N+1으로 해야함 
        order = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 방향 X의 간선 입력받기 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 정점 
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(R);
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append('\n');
        }
        System.out.print(sb);
    }
    
    // dfs 구현 
    static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (order[current] != 0) { continue; } // 이미 방문한 정점 스킵하기 

            order[current] = count++;

            // 스택 역순으로 넣고 pop하기 
            List<Integer> adj = graph[current];
            // 정점 꺼내서 인접하기 않은 정점 스택 넣고 dfs 진행 
            for (int i = adj.size() - 1; i >= 0; i--) {
                int next = adj.get(i);
                if (order[next] == 0) {
                    stack.push(next);
                }
            }
        }
    }
}
