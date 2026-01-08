import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int to, weight;
        
        public Node(int to, int weight) {
            this.to=to;
            this.weight=weight;
        }
    }
    
    static List<Node>[] tree;
    static boolean[] visited;
    static int maxDistance = 0;
    static int maxNode = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        tree = new ArrayList[n+1];
        for (int i=0; i<=n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            // 현재 무방향 그래프이므로 양방향도 추가
            tree[from].add(new Node(to,weight));
            tree[to].add(new Node(from,weight));
        }
        
        // 1번 노드에서 가장 먼 노드 찾는 dfs
        visited = new boolean[n+1];
        dfs(1,0);
        
        // 가장 먼 노드에서 다시 dfs 수행해서 지름 계산하기 
        visited = new boolean[n+1];
        maxDistance = 0;
        dfs(maxNode,0);
        
        System.out.println(maxDistance);
    }
    
    // dfs 구현
    static void dfs(int current, int distance) {
        visited[current] = true;
        
        if (distance > maxDistance) {
            maxDistance = distance;
            maxNode = current;
        }
        
        for (Node next : tree[current]) {
            if (!visited[next.to]) {
                dfs(next.to, distance + next.weight);
            }
        }
    }
}