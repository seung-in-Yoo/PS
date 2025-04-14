import java.util.*;

// 큐 사용하는 구현 문제 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        Queue<Integer> queue = new LinkedList<>(); // 큐를 사용하기 위해 큐 선언
        for (int i=1; i<=N; i++) {
            queue.add(i);
        }
        
        List<Integer> result = new ArrayList();
        
        while(!queue.isEmpty()) {
            for (int i=0; i< K-1; i++) {
                queue.add(queue.poll()); // 맨 앞 숫자 꺼내서 뒤로
            }
            
            result.add(queue.poll()); 
        }
        
        System.out.print("<");
        for (int i=0; i<result.size(); i++) {
            if(i != result.size()-1) {
                System.out.print(result.get(i) + ", ");
            } else {
                System.out.print(result.get(i));
            }
        }
        System.out.println(">");
    }
}