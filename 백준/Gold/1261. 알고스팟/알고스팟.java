import java.util.*;

// 최단 거리 문제가 아니고 최소 비용 문제임.
// 이동 비용: 빈 방(0): 비용 0, 벽(1): 비용 1
// 시작점 (0,0)에서 BFS 시작
// 방문 시 벽 부순 횟수를 배열로 저장
// => 이동 비용이 두 가지(0과 1)로 고정
public class Main {
    static int M, N;
    static int[][] map;
    static int[][] dist;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt(); 
        N = sc.nextInt(); 
        sc.nextLine();

        map = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();

        System.out.println(dist[N - 1][M - 1]);
    }

    static void bfs() {
        Deque<Point> deque = new ArrayDeque<>();
        deque.addFirst(new Point(0, 0));
        dist[0][0] = 0; 

        while (!deque.isEmpty()) {
            Point now = deque.pollFirst();

            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                int cost = map[nx][ny];

                if (dist[nx][ny] > dist[now.x][now.y] + cost) {
                    dist[nx][ny] = dist[now.x][now.y] + cost;

                    if (cost == 1) {
                        deque.addLast(new Point(nx, ny)); 
                    } else {
                        deque.addFirst(new Point(nx, ny)); 
                    }
                }
            }
        }
    }
}
