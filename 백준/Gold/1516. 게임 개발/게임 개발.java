import java.util.*;

public class Main {
    static int N;
    static int[] time, result, indegree;
    static List<Integer>[] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        time = new int[N + 1];         
        result = new int[N + 1];       // 최종 걸리는 시간 
        
        indegree = new int[N + 1];     // 진입 차수 
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>(); 
        }

        
        for (int i = 1; i <= N; i++) {
            time[i] = sc.nextInt(); // 건물 자체를 짓는 시간

            while (true) {
                int building = sc.nextInt(); // 선행 건물 번호 
                if (building == -1) {
                    break;
                }

                graph[building].add(i);  
                indegree[i]++; // 진입차수 ++ 
            }
        }

        
        Queue<Integer> q = new LinkedList<>();

        
        // 진입 차수가 0인 건물들을 큐에 넣기 
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                result[i] = time[i]; // 선행 건물 없으면 자기 시간 그대로
            }
        }

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : graph[current]) {
                indegree[next]--;
                
                // next 건물은 여러 선행 건물을 가질 수 있기에, 가장 오래 걸린 선행 건물을 기준으로 
                result[next] = Math.max(result[next], result[current] + time[next]);

                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }
    }
}