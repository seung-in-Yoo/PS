import java.util.*;

// 그리디 알고리즘 -> 5키로 가능하면 무조건 5키로부터 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 설탕의 무게 (단위:kg)
        int count = 0;
        while (N >= 0) {
            if (N % 5 == 0) { 
                count += N / 5;
                System.out.println(count);
                return;
            }
           
            N -= 3;
            count++;
        }
        
        System.out.println(-1);
    }
}