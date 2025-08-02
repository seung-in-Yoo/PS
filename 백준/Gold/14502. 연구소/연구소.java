import java.util.*;
import java.io.*;
//완전탐색 문제 3개의 벽을 세운 뒤 0에서 -> 2로 퍼지게 하고 나서 안전구역 카운트해서 최대값 갱신 
// 모든 조합으로 해서 탐색해야함

public class Main {
    static int N, M;
    static int[][] map; // 처음에 입력받을 지도 
    static ArrayList<Point> virus = new ArrayList<>(); // 바이러스의 좌표 저장할 배열
    static ArrayList<Point> blank = new ArrayList<>(); // 빈 칸의 좌표 저장할 배열
    static int maxSafe = 0; // 안전 구역의 최대 크기
    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // 입력받고, 바이러스와 빈칸의 좌표 저장함 
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) { 
                    virus.add(new Point(i, j)); // 바이러스에 저장 
                } else if (map[i][j] == 0) {
                    blank.add(new Point(i, j)); // 빈칸에 저장
                }
            }
        }

        // 빈 칸 중 3개 조합 고르기
        combination(0, 0, new Point[3]);

        // 정답 출력
        System.out.println(maxSafe);
    }

    // 빈칸 중에서 벽 세울 3개를 선택하는 조합 로직 
    static void combination(int start, int depth, Point[] selected) {
        if (depth == 3) {
            simulate(selected);
            return;
        }
        for (int i = start; i < blank.size(); i++) {
            selected[depth] = blank.get(i);
            combination(i + 1, depth + 1, selected);
        }
    }

    // 벽 세우고 바이러스 퍼뜨린 뒤 안전구역 개수 세기
    static void simulate(Point[] walls) {
        int[][] tempMap = new int[N][M];// 맵 복사 (기존 맵 건드리면 못품)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

        for (Point p : walls) {
            tempMap[p.x][p.y] = 1;
        }

        // BFS 이용해서 바이러스 퍼뜨리기 
        Queue<Point> q = new LinkedList<>();
        for (Point v : virus) q.add(v);

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) { continue; }
                if (tempMap[nx][ny] == 0) {
                    tempMap[nx][ny] = 2;
                    q.add(new Point(nx, ny));
                }
            }
        }
        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0) { safe++; }
            }
        }
        maxSafe = Math.max(maxSafe, safe); // 최대값 갱신해서 답 구하기
    }
}