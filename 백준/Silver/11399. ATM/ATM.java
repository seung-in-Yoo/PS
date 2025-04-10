import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] needTime = new int[N];
        
        for (int i=0; i<N; i++) {
            needTime[i] = sc.nextInt();
        }
        
        Arrays.sort(needTime);
        
        int total = 0;
        int sum = 0;
        
        for (int i = 0; i < N; i++) {
            sum += needTime[i]; 
            total += sum;       
        }

        System.out.println(total);
    }
}