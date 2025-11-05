import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] want;  // 학생이 원하는 책 리스트
    static int[] book;            // 각각의 책이 어떤 학생에게 할당되었는지 저장하는 배열 
    static boolean[] visited;     // DFS용 방문 체크

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 문제에서 나온 테스트 케이스 수

        while (T-- > 0) {
            N = sc.nextInt(); // 책 수
            M = sc.nextInt(); // 학생 수

            want = new ArrayList[M + 1];
            for (int i = 1; i <= M; i++) {
                want[i] = new ArrayList<>();
            }

            for (int i = 1; i <= M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                for (int j = a; j <= b; j++) {
                    want[i].add(j);
                }
            }

            book = new int[N + 1]; 
            Arrays.fill(book, 0);  

            int result = 0;
            for (int i = 1; i <= M; i++) {
                visited = new boolean[N + 1]; 
                if (dfs(i)) result++;
            }

            System.out.println(result);
        }
    }

    // 학생 x가 원하는 책을 하나 배정받을 수 있는지 확인하는 dfs 로직 
    static boolean dfs(int student) {
        for (int b : want[student]) {
            if (visited[b]) continue;
            visited[b] = true;

            // 아직 아무도 이 책을 가지지 않았거나
            // 이 책을 가진 학생이 다른 책으로 이동 가능하면 현재 학생에게 배정하기 
            if (book[b] == 0 || dfs(book[b])) {
                book[b] = student;
                return true;
            }
        }
        return false;
    }
}
