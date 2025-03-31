import java.util.Scanner;

// DFS, 시뮬레이션

public class Main {
    static int N; 
    static int[][] board; // 2차원 배열로 게임 보드 저장
    static int maxBlock = 0; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt(); 
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        dfs(board, 0);

        System.out.println(maxBlock);
    }

    // DFS 구현하기 
    public static void dfs(int[][] currentMap, int count) {
        // 이동을 5번 했으면 최댓값 갱신 후 종료
        if (count == 5) {
            updateBlock(currentMap);
            return;
        }

        // 4방향으로 이동 이동 
        for (int direction = 0; direction < 4; direction++) {
            int[][] nextBoard = copyBoard(currentMap); 
            move(nextBoard, direction); // 보드를 특정 방향으로 이동
            dfs(nextBoard, count + 1); // 재귀 사용하여 다음으로 이동 
        }
    }
    
    // 이동 함수 구현 
    public static void move(int[][] board, int dir) {
        if (dir == 0) { // 위로 이동하는 경우 
            for (int y = 0; y < N; y++) {
                int p = 0; // 새로운 위치 (이동 후 저장할 위치)
                for (int x = 1; x < N; x++) {
                    if (board[x][y] == 0) {
                        continue;
                    }// 빈 칸이면 무시
                    int now = board[p][y]; 
                    int next = board[x][y]; 
                    board[x][y] = 0; // 원래 위치 비우기
                    if (now == 0) {
                        board[p][y] = next; // 자리가 빈자리면 이동하기 
                    }
                    else if (now == next) {
                        board[p][y] *= 2; // 같은 값이면 합치기
                        p++; // 합쳐진 블록 다음으로 이동
                    } else {
                        p++; // 새로운 자리로 이동
                        board[p][y] = next;
                    }
                }
            }
        } else if (dir == 1) { // 아래로 이동하는 경우 (동일하게 구현)
            for (int y = 0; y < N; y++) {
                int p = N - 1;
                for (int x = N - 2; x >= 0; x--) {
                    if (board[x][y] == 0) continue;
                    int now = board[p][y];
                    int next = board[x][y];
                    board[x][y] = 0;
                    if (now == 0) board[p][y] = next;
                    else if (now == next) {
                        board[p][y] *= 2;
                        p--;
                    } else {
                        p--;
                        board[p][y] = next;
                    }
                }
            }
        } else if (dir == 2) { // 왼쪽으로 이동하는 경우 (동일하게 구현)
            for (int x = 0; x < N; x++) {
                int p = 0;
                for (int y = 1; y < N; y++) {
                    if (board[x][y] == 0) continue;
                    int now = board[x][p];
                    int next = board[x][y];
                    board[x][y] = 0;
                    if (now == 0) board[x][p] = next;
                    else if (now == next) {
                        board[x][p] *= 2;
                        p++;
                    } else {
                        p++;
                        board[x][p] = next;
                    }
                }
            }
        } else { // 오른쪽으로 이동하는 경우 (동일하게 구현)
            for (int x = 0; x < N; x++) {
                int p = N - 1;
                for (int y = N - 2; y >= 0; y--) {
                    if (board[x][y] == 0) continue;
                    int now = board[x][p];
                    int next = board[x][y];
                    board[x][y] = 0;
                    if (now == 0) board[x][p] = next;
                    else if (now == next) {
                        board[x][p] *= 2;
                        p--;
                    } else {
                        p--;
                        board[x][p] = next;
                    }
                }
            }
        }
    }

    public static int[][] copyBoard(int[][] original) {
        int[][] newBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(original[i], 0, newBoard[i], 0, N);
        }
        return newBoard;
    }

    public static void updateBlock(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxBlock = Math.max(maxBlock, board[i][j]);
            }
        }
    }
}
