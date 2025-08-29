import java.io.*;
import java.util.*;

// DFS 완전 탐색 + 시뮬레이션 혼합 
// 각 칸마다 다음 칸을 미리 저장해두고, 파란 칸에서 출발하면 다른 경로를 따라가도록 해야함
// DFS 백트래킹 이용하여 DFS 중 얻을 수 있는 최대 점수 구해야하고 
// 10턴 동안 매번 4개의 말 중 하나를 선택, 눈금대로 이동하면서 점수는 누적 
// 각 칸 => 노드 번호로 생각하고 
public class Main {
    static int[] dice = new int[10];
    static int maxScore = 0;
    static int[] next = new int[33]; // 다음 위치 
    static int[] blue = new int[33]; // 파란 화살표로 움직이는 곳들
    static int[] score = new int[33]; // 각 칸의 점수들 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        init();
        dfs(0, new int[4], 0); 
        System.out.println(maxScore);
    }

    // 보드 (웇놀이 판) 초기화 하기 
    static void init() {
        // 기본 경로
        for (int i = 0; i <= 20; i++) {
            next[i] = i + 1;
            score[i] = i * 2;
        }
        next[20] = 32; // 40에서 도착
        score[0] = 0;

        // 파란길
        blue[5] = 21; 
        blue[10] = 25; 
        blue[15] = 27; 

        // 10 파란길 
        score[21] = 13; next[21] = 22;
        score[22] = 16; next[22] = 23;
        score[23] = 19; next[23] = 24;

        // 20 파란길 
        score[25] = 22; next[25] = 26;
        score[26] = 24; next[26] = 24; 

        // 30 파란길 
        score[27] = 28; next[27] = 28;
        score[28] = 27; next[28] = 29;
        score[29] = 26; next[29] = 24;

        // 교차점 
        score[24] = 25; next[24] = 30;
        score[30] = 30; next[30] = 31;
        score[31] = 35; next[31] = 20;

        
        score[32] = 0;
    }

    // DFS 백트래킹 구현 
    static void dfs(int turn, int[] pos, int sum) {
        if (turn == 10) {
            maxScore = Math.max(maxScore, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int now = pos[i];
            if (now == 32) { continue; } // 이미 도착한 말

            int nextPos = move(now, dice[turn]);

            if (nextPos != 32 && contain(pos, nextPos)) { continue; } // 겹치면 안됨 

            int before = pos[i];
            pos[i] = nextPos;

            dfs(turn + 1, pos, sum + (nextPos == 32 ? 0 : score[nextPos]));

            pos[i] = before; 
        }
    }

    // 말 이동
   static int move(int start, int d) {
        int current = start;
        if (current == 32) { return 32; }

        if (blue[current] != 0) { 
            current = blue[current];
            d--;
        } else {
            current = next[current];
            d--;
        }

        while (d > 0 && current != 32) {
            current = next[current];
            d--;
        }
        return current;
    }

    // 겹치는지 체크 
    static boolean contain(int[] pos, int x) {
        if (x == 32) { return false; } 
        for (int p : pos) {
            if (p == x) { return true; }
        }
        return false;
    }
}