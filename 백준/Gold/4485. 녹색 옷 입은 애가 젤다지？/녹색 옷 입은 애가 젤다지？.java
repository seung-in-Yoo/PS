import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int r, c, cost; 
        Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost; // 비용 오름차순으로 
        }
    }

    static int N;
    static int[][] map;
    static int[][] distance;
    
    // 상하좌우 설정 
    static int[] dr = {-1, 1, 0, 0}; 
    static int[] dc = {0, 0, -1, 1}; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int problem = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            map = new int[N][N];
            distance = new int[N][N];

            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
            dijkstra();
            System.out.println("Problem " + problem + ": " + distance[N - 1][N - 1]);
            problem++;
        }
    }
    
    // 다익스트라 구현 
    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        distance[0][0] = map[0][0]; 
        pq.offer(new Node(0, 0, map[0][0]));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int r = current.r;
            int c = current.c;
            int cost = current.cost;

            // 비용을 이용해서 더 좋은 경로가 있으면 제외 
            if (cost > distance[r][c]) {
                continue;
            }

            if (r == N - 1 && c == N - 1) {
                return;
            }

            // 상하좌우 탐색
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 범위 체크
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                    continue;
                }

                int nextCost = cost + map[nr][nc];

                if (nextCost < distance[nr][nc]) {
                    distance[nr][nc] = nextCost;
                    pq.offer(new Node(nr, nc, nextCost));
                }
            }
        }
    }
}
