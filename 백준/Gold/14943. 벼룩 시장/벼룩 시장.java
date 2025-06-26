import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong(); 
        }

        long sum = 0;
        long cost = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];        
            cost += Math.abs(sum); 
        }
        System.out.println(cost);
    }
}
