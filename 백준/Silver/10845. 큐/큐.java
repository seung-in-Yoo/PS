import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // Scanner로 풀었더니 시간초과나서 바꿈 
        
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last = -1; // 가장 최근에 들어온 값 

        for (int i = 0; i < N; i++) {
            String order = br.readLine();

            if (order.startsWith("push")) {
                int x = Integer.parseInt(order.split(" ")[1]);
                queue.offer(x); // 큐에 값 추가
                last = x;       
            } else if (order.equals("pop")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.poll()); // 큐에서 제거 
                }
            } else if (order.equals("size")) {
                System.out.println(queue.size());
            } else if (order.equals("empty")) {
                System.out.println(queue.isEmpty() ? 1 : 0);
            } else if (order.equals("front")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.peek()); 
                }
            } else if (order.equals("back")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(last); // 마지막으로 넣은 값을 기억해두었다가 출력
                }
            }
        }
    }
}
