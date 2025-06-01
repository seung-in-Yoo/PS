import java.util.*;

// 다익스트라 정방향,역방향으로 2번 사용 
public class Main {
    static class Edge {
        int to, time;

        public Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }

    static final int INF = Integer.MAX_VALUE; // 무한대 값 
    static int N, M, X; // 마을,도로,마을 번호 
    static List<Edge>[] graph; // 정방향 그래프
    static List<Edge>[] reverseGraph; // 역방향 그래프 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        X = sc.nextInt();

        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
        
        // 간선정보 
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int time = sc.nextInt();

            graph[from].add(new Edge(to, time));
            reverseGraph[to].add(new Edge(from, time)); 
        }

        
        int[] toVillage = dijkstra(X, reverseGraph);
        int[] fromVillage = dijkstra(X, graph);

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            int roundTrip = toVillage[i] + fromVillage[i];
            maxTime = Math.max(maxTime, roundTrip);
        }

        System.out.println(maxTime);
    }
    
    // start 정점에서 모든 정점까지 최단 거리 구하는 다익스트라 함수 
    static int[] dijkstra(int start, List<Edge>[] g) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        // 비용이 작은순으로 우선순위 큐 
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.time));
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll(); // 현재 방문하는 정점 
            int now = current.to;
            int cost = current.time;

            if (dist[now] < cost) continue;

            for (Edge next : g[now]) {
                int nextNode = next.to;
                int newCost = cost + next.time;
                
                // 짧은 경로 발견하면 경로 갱신 
                if (newCost < dist[nextNode]) {
                    dist[nextNode] = newCost;
                    pq.offer(new Edge(nextNode, newCost));
                }
            }
        }
        return dist;
    }
}
