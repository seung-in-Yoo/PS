import java.util.*;
import java.io.*;
// 현재 일부 학생들만 비교하는 제약조건 + 키 비교하는 위상 정렬 문제 
// 학생을 노드로 잡고, 비교하는걸 간선으로 잡아서 그래프 문제로 
// 간선으로 그래프 만들기 -> 답이 여러개여도 된다 
// 0 에서 큐로 가는데 
// 큐에서 빼면서 차수 줄이기, 0되면 큐에 넣기

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 

        List<Integer>[] graph = new ArrayList[N+1]; 
        
        for (int i = 1; i <= N; i++) { graph[i] = new ArrayList<>(); }
        int[] degree = new int[N+1]; // 진입하는 차수 

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B); // A가 B보다 앞에 서야 한다라고하면 A→B 간선 추가
            degree[B]++; // B에 대한 조건 차수 추가 
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) { q.add(i); } // 앞에 아무도 없으니 줄세우기 (조건 X)
        }

        StringBuilder sb = new StringBuilder();
        
        while (!q.isEmpty()) {
            int first = q.poll();
            sb.append(first).append(" ");
            for (int next : graph[first]) {
                degree[next]--;
                if (degree[next] == 0) { q.add(next); } // 앞에 설 사람 없으면 큐에 추가 
            }
        }

        System.out.println(sb.toString().trim()); // 마지막에 .trim 안넣어서 처음에 틀림 
    }
}
