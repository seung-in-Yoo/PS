import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        sc.nextLine();

        Stack<Integer> stack = new Stack<>(); // 스택 사용 

        for (int i = 0; i < N; i++) {
            String command = sc.nextLine();

            if (command.startsWith("push")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                stack.push(value); // push 사용 
            } else if (command.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop()); // pop 사용 
                }
            } else if (command.equals("size")) {
                System.out.println(stack.size()); // size 출력 
            } else if (command.equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0); // 비어있는지 확인후 1 아니면 0 출력 
            } else if (command.equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek()); // 스택 가장 위 정수 빼내는 peek 사용 
                }
            }
        }
    }
}
