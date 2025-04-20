import java.util.*;

// 구현 문제는 실버도 코드가 길고 까다로워서 연습 꾸준히 해야할듯 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine()); // N*N으로 그려질 정수 받기
        char[][] map = new char[N][N]; // 쿠키런이 그려질 지도 배열
        
        for (int i=0; i<N; i++) {
            map[i] = sc.nextLine().toCharArray(); // 지도 입력 받기
        }
        
        int heartX = 0; // 심장의 X좌표
        int heartY = 0; // 심장의 Y좌표
        
        // 심장의 위치를 찾아야하는데 머리의 바로 아래이기 때문에 처음으로 * 나오는거 바로 아래가 심장의 위치임
        for (int i=1; i<N-1; i++) {
            for (int j=1; j<N-1; j++) {
                if (map[i][j] == '*' &&
                   map[i-1][j] == '*' && map[i+1][j] == '*' &&
                   map[i][j-1] == '*' && map[i][j+1] == '*') {
                    heartX = i;
                    heartY = j;
                    break;
                }
            }
            if (heartX != 0) {
                break;
            }
        }
        // 왼팔 부분
        int left = 0;
        int y = heartY - 1;
        while (y >= 0 && map[heartX][y] == '*') {
            left++;
            y--; // 왼쪽 방향으로 가야하는 y 값 줄이기 
        }
        // 오른팔 부분 
        int right = 0;
        y = heartY + 1;
        while (y < N && map[heartX][y] == '*') {
            right++;
            y++;
        }
        // 허리 부분 
        int waist = 0;
        int x = heartX + 1;
        while (x < N && map[x][heartY] == '*') {
            waist++;
            x++;
        }

        // 다리는 허리의 끝에서 양 옆 아래로 내려가며 확인
        int leftLeg = 0, rightLeg = 0;
        int legX = heartX + waist + 1;
        while (legX < N && map[legX][heartY - 1] == '*') {
            leftLeg++;
            legX++;
        }

        legX = heartX + waist + 1;
        while (legX < N && map[legX][heartY + 1] == '*') {
            rightLeg++;
            legX++;
        }

        System.out.println((heartX + 1) + " " + (heartY + 1));
        System.out.println(left + " " + right + " " + waist + " " + leftLeg + " " + rightLeg);
        
    }
}