import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int winner = 0;
        int maxDigit = -1;

        for (int i = 1; i <= N; i++) {
            int[] cards = new int[5];
            for (int j = 0; j < 5; j++) {
                cards[j] = scanner.nextInt();
            }

            int maxCurrent = 0;
         
            for (int a = 0; a < 3; a++) {
                for (int b = a + 1; b < 4; b++) {
                    for (int c = b + 1; c < 5; c++) {
                        int sum = cards[a] + cards[b] + cards[c];
                        int digit = sum % 10;
                        if (digit >= maxCurrent) {
                            maxCurrent = digit;
                        }
                    }
                }
            }

            
            if (maxCurrent >= maxDigit) {
                maxDigit = maxCurrent;
                winner = i;
            }
        }

        System.out.println(winner);
        scanner.close();
    }
}