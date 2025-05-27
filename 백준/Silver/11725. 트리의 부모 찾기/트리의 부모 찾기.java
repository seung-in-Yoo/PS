import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        graph = new ArrayList[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 무방향으로 입력 받기 
        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        bfs(1); // 루트를 1로 설정하고 BFS 시작

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }
    
    // bfs 구현 함수 
    static void bfs(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        visited[root] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int value : graph[current]) {
                if (!visited[value]) {
                    parent[value] = current; 
                    visited[value] = true;
                    queue.add(value);
                }
            }
        }
    }
}
