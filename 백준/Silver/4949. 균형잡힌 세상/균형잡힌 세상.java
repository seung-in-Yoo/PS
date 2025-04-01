import java.io.*;
import java.util.*;

// 전형적인 스택 활용 문제
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (true) {
            String sentence = sc.nextLine(); // 한줄씩 입력받기 
            if (sentence.equals(".")) {
                break; 
            }
            if (isStack(sentence)) { // 스택 함수를 만족하면 yes 출력
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public static boolean isStack(String s) {
        Stack<Character> stack = new Stack<>(); // 스택 선언 

        for (char c : s.toCharArray()) { // 문자열을 한 글자씩 확인
            if (c == '(' || c == '[') { 
                stack.push(c); // 여는 괄호는 스택에 넣기
            } else if (c == ')') { 
                if (stack.isEmpty()) {
                  return false; // 스택이 비었으면 false
                } 
                if (stack.pop() != '(') {
                    return false; // '(' 말고 다른게 오면 false
                }
            } else if (c == ']') { 
                if (stack.isEmpty()) {
                    return false; // 스택이 비었으면 false
                } 
                if (stack.pop() != '[') {
                    return false; // '[' 말고 다른게 오면 false
                }
            }
        }

        return stack.isEmpty(); // 스택이 비어 있어야 "yes"
    }
}
