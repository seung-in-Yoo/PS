import java.util.*;

// 시뮬레이션 + BFS
public class Main {
    static int N, M, P;               // 맵 크기 및 플레이어 수
    static int[] speeds;              // 각 플레이어의 확장 속도 (Si)
    static int[] result;              // 각 플레이어가 차지한 성의 수
    static char[][] map;              // 게임 맵
    static Queue<int[]>[] queues;     // 각 플레이어의 BFS 큐
    static int[] dx = {-1, 0, 1, 0};  
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 행
        M = sc.nextInt(); // 열
        P = sc.nextInt(); // 플레이어 수

        speeds = new int[P + 1];     
        result = new int[P + 1];     
        queues = new LinkedList[P + 1];

        for (int i = 1; i <= P; i++) {
            speeds[i] = sc.nextInt();
            queues[i] = new LinkedList<>();
        }

        map = new char[N][M];
        
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                // 성이면 해당 플레이어의 큐에 삽입
                if (map[i][j] >= '1' && map[i][j] <= '9') {
                    int player = map[i][j] - '0';
                    queues[player].add(new int[]{i, j});
                    result[player]++;
                }
            }
        }

        boolean changed = true;

        // 모든 플레이어가 더 이상 확장을 못 할 때까지 반복
        while (changed) {
            changed = false;

            for (int i = 1; i <= P; i++) {
                Queue<int[]> nextQueue = new LinkedList<>();
                Queue<int[]> currentQueue = queues[i];

                int steps = speeds[i];

                // 최대 Si만큼 BFS로 성 확장
                for (int step = 0; step < steps; step++) {
                    int size = currentQueue.size();
                    if (size == 0) break;

                    for (int j = 0; j < size; j++) {
                        int[] cur = currentQueue.poll();
                        int x = cur[0], y = cur[1];

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            // 범위 벗어나거나 벽이거나 다른 성이면 건너뜀
                            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                            if (map[nx][ny] != '.') continue;

                            map[nx][ny] = (char) (i + '0');
                            result[i]++;
                            currentQueue.add(new int[]{nx, ny});
                            changed = true;
                        }
                    }
                }
                queues[i] = currentQueue;
            }
        }

        for (int i = 1; i <= P; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
