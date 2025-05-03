import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        int N = Integer.parseInt(br.readLine()); // 승환이 앞에 서 있는 학생들의 수
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 현재 줄 서있는 상태를 표현하고, 앞에 있는 사람부터 대기줄로 들어가는 선입선출 구조이기 때문에 큐 사용
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }
        
        Stack<Integer> stack = new Stack<>(); // 다시 나올때는 후입선출 (대기줄에 있는 사람들)
        int target = 1; // 간식을 받을 타겟(사람)의 번호는 1부터 시작
        
        while (!queue.isEmpty()) {
            int current = queue.poll(); // 대기줄로 사람들 보내기
            
            if (current == target) {
                target++; // 대기줄이랑 타겟이랑 일치하면 바로 간식 지급 
            } else {
                stack.push(current); // 아니면 스택에 보관 
            }
            
            while (!stack.isEmpty() && stack.peek() == target) {
                stack.pop(); // 스택에 남아있는게 타겟과 일치하게 정렬이면 간식 지급함 
                target++;
            }
        }
        
        if (target == N + 1) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}