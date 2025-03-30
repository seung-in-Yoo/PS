import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        while (true) {
            if (isPrime(N) && isPalindrome(N)) {
                System.out.println(N);
                break;
            }
            N++;
        }
    }
    
    // 소수인지 판별하는 함수 
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    // 펠린드롬 판별하는 함수 
    private static boolean isPalindrome(int n) {
        String str = String.valueOf(n);
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}