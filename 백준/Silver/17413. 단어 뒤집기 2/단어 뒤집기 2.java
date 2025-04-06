import java.util.*;

// 스택 활용 문제 -> 다시 한번 더 풀어보기 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine(); 

        Stack<Character> stack = new Stack<>(); // 스택 사용 
        boolean Tag = false; // 현재 태그 내부인지 아닌지 상태를 저장

        for (char c : input.toCharArray()) {
            if (c == '<') {
                // 태그가 시작되기 전에 쌓여 있던 단어를 뒤집어서 출력
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }
                Tag = true; // 태그 시작
                System.out.print(c); 
            } else if (c == '>') {
                Tag = false; // 태그 종료
                System.out.print(c); 
            } else if (Tag) { // 태그 내부의 문자는 그대로 출력
                System.out.print(c);
            } else { // 태그 밖이면 뒤집어서 출력 
                if (c == ' ') {
                    // 지금까지 스택에 쌓인 문자를 뒤집어서 출력
                    while (!stack.isEmpty()) {
                        System.out.print(stack.pop());
                    }
                    System.out.print(' '); 
                } else {
                    stack.push(c);
                }
            }
        }
        
        // 스택에 남아있는 단어 뒤집어서 출력
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
