import java.util.*;

/*
퍼즐 상태를 문자열로 표현하고
매 상태마다 가능한 이동을 탐색해서 bfs 적용 최단 거리 탐색
방문한 상태는 다시 방문하지 않기 위해서 중복 방지 있어야함
*/

public class Main {
    static final String goal = "123456780";
    static int[] dx = {-1, 1, 0, 0}; // 위,아래 이동
    static int[] dy = {0, 0, -1, 1}; // 왼쪽,오른쪽 이동

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder start = new StringBuilder();
        for (int i = 0; i < 3 * 3; i++) {
            start.append(sc.nextInt());
        }

        System.out.println(bfs(start.toString()));
    }

    // BFS로 최소 이동 횟수 구하기
    static int bfs(String start) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> dist = new HashMap<>();

        queue.add(start);
        dist.put(start, 0);

        while (!queue.isEmpty()) {
            String now = queue.poll();

            
            if (now.equals(goal)) {return dist.get(now);}

            int zeroIndex = now.indexOf('0'); // 빈칸의 위치
            int x = zeroIndex / 3;
            int y = zeroIndex % 3;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 격자 밖으로 나가면 무효 
                if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) {continue;}

                int swapIndex = nx * 3 + ny; // 1차원 인덱스로 교환 
                String next = swap(now, zeroIndex, swapIndex);

                if (!dist.containsKey(next)) {
                    dist.put(next, dist.get(now) + 1); // 횟수 기록 후, 다시 bfs 진행 
                    queue.add(next);
                }
            }
        }

        return -1; 
    }

    // 문자열에서 두 인덱스의 문자 바꾸기 
    static String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}
