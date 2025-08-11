import java.io.*;
import java.util.*;

// 최소신장트리 유형 -> 모든 컴퓨터를 연결하는데 비용을 최소로 
// 간선 정보 저장 
class Edge implements Comparable<Edge> {
    int a, b, cost;
    
    Edge(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost; // 비용 오름차순 정렬 
    }
}

public class Main {
    static int[] parent; // 부모 배열 생성 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 컴퓨터 개수 => 이게 노드 
        int M = Integer.parseInt(br.readLine()); // 연결 가능한 선 개수 => 이게 간선 

        List<Edge> edges = new ArrayList<>(); // 간선 정보 저장 
        
        // a와 b를 cost 비용으로 연결
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            edges.add(new Edge(a, b, cost));
        }

        Collections.sort(edges); // 간선 => 비용 기준으로 정렬 

        parent = new int[N + 1];
        for (int i=1; i<=N; i++) { parent[i] = i; }

        int total = 0;
        int count = 0;
        
        // 비용이 낮은 간선부터 쭉 확인 
        for (Edge e : edges) {
            if (findParent(e.a) != findParent(e.b)) { // 사이클 방지
                plus(e.a, e.b); // 정점 연결 
                total += e.cost; // 비용 추가
                count++; // 간선 카운트 추가 
                if (count == N - 1) { break; } 
            }
        }

        System.out.println(total);
    }
    
    // 부모 찾는 함수 구현 
    static int findParent(int x) {
        if (parent[x] == x) { return x; }
        return parent[x] = findParent(parent[x]); 
    }

    static void plus(int a, int b) {
        a = findParent(a);
        
        b = findParent(b);
        if (a != b) { // 루트가 다르면 합쳐야함 
            if (a < b) { parent[b] = a; }
            else { parent[a] = b; }
        }
    }
}