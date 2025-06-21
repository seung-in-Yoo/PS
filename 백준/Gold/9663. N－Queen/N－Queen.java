import java.util.Scanner;

public class Main {
    static int N;
    static int result = 0;
    static int[] chessBoard; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        chessBoard = new int[N];
        solve(0); 
        System.out.println(result);
    }

    static void solve(int row) {
        if (row == N) {
            result++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (safety(row, col)) {
                chessBoard[row] = col;     
                solve(row + 1);       
            }
        }
    }

    static boolean safety(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (chessBoard[i] == col || Math.abs(row - i) == Math.abs(col - chessBoard[i])) {
                return false;
            }
        }
        return true;
    }
}
