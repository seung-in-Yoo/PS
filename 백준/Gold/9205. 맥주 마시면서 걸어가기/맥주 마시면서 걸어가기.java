import java.util.*;
import java.io.*;


// 맥주 20병 -> 최대 1000m 이동 가능 , 이동중에 편의점에 도착하면 맥주 다시 20병으로 리셋
// 그러므로 1000m 이내 이동을 반복해서 페스티벌에 도착할 수 있는지 확인 (노드,간선)
// BFS로 아직 방문 안하고 거리가 1000 이하인 편의점 및 페스티벌을 큐에 추가하면서 문제풀기


public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Point[] places = new Point[n+2];
            
            for (int i=0; i<n+2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                places[i] = new Point(x,y);
            }
            
            boolean[] visited = new boolean[n+2];
            Queue<Integer> q = new LinkedList<>();
            q.add(0); // 집에서 시작하기
            visited[0] = true;
            boolean happy = false;
            
            while (!q.isEmpty()) {
                int current = q.poll();
                
                if (current == n+1) {
                    // 페스티벌 도착
                    happy = true;
                    break;
                }
                
                for (int i=0; i<n+2; i++) {
                    if (visited[i]) {continue;}
                    
                    int distance = Math.abs(places[current].x - places[i].x) + Math.abs(places[current].y - places[i].y);
                    
                    if (distance <= 1000) {
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }
            
            sb.append(happy ? "happy\n" : "sad\n"); // happy가 true이면 happy false면 sad로 
        }
        
        System.out.print(sb.toString());
    }
}