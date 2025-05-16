import java.util.*;

public class Main {
    static boolean[] isPrime = new boolean[19]; // 소수 넣을 배열 선언 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // A팀의 득점 확률
        int b = sc.nextInt(); // B팀의 득점 확률 

        countPrime();

        double pA = a / 100.0;
        double pB = b / 100.0;

        double[] probA = new double[19]; // A팀의 골 확률
        double[] probB = new double[19]; // B팀의 골 확률 

        // A팀 골 확률
        for (int i = 0; i <= 18; i++) {
            probA[i] = combination(18, i) * Math.pow(pA, i) * Math.pow(1 - pA, 18 - i);
        }

        // B팀 골 확률
        for (int i = 0; i <= 18; i++) {
            probB[i] = combination(18, i) * Math.pow(pB, i) * Math.pow(1 - pB, 18 - i);
        }

        double result = 0.0;
        for (int i = 0; i <= 18; i++) {
            for (int j = 0; j <= 18; j++) {
                if (isPrime[i] || isPrime[j]) {
                    result += probA[i] * probB[j];
                }
            }
        }

        System.out.println(result);
    }
    
    // 조합 구현하는 함수 (순서 고려하지않고 n개중에 r개 선택)
    static long combination(int n, int r) {
        long res = 1;
        for (int i = 0; i < r; i++) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }
    
    // 소수 판별 
    static void countPrime() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0과 1은 소수에서 제외 
        for (int i = 2; i * i <= 18; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 18; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
