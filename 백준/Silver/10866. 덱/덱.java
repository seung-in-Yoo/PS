import java.util.*;
import java.io.*;
// 양방향 큐 구현하는 기본 시뮬레이션 문제 -> 문제 따라 그대로 구현만 하면 됨
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); 
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.startsWith("push_front")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                deque.addFirst(value);
            } else if (command.startsWith("push_back")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                deque.addLast(value);
            } else if (command.equals("pop_front")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    int front = deque.pollFirst();
                    sb.append(front).append("\n");
                }
            } else if (command.equals("pop_back")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    int back = deque.pollLast();
                    sb.append(back).append("\n");
                }
            } else if (command.equals("size")) {
                int size = deque.size();
                sb.append(size).append("\n");
            } else if (command.equals("empty")) {
                if (deque.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (command.equals("front")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    int front = deque.peekFirst();
                    sb.append(front).append("\n");
                }
            } else if (command.equals("back")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    int back = deque.peekLast();
                    sb.append(back).append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}
