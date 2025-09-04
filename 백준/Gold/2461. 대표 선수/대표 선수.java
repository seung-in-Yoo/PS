import java.util.*;
import java.io.*;

// 정렬 + 슬라이딩 윈도우 (투포인터)
public class Main {
    static class Player {
        int ability;      // 능력치 
        int classNumber;  // 학생 속한 반 번호

        Player(int ability, int classNumber) {
            this.ability = ability;
            this.classNumber = classNumber;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학급 수
        int M = Integer.parseInt(st.nextToken()); // 각 반 학생 수

        List<Player> players = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int ability = Integer.parseInt(st.nextToken());
                players.add(new Player(ability, i));
            }
        }

        // 능력치 기준으로 정렬
        players.sort(Comparator.comparingInt(p -> p.ability));

        // 투 포인터 시작 
        int left = 0;
        int result = Integer.MAX_VALUE;
        int[] count = new int[N]; // 각 반에서 몇 명이 선택됐는지 카운트 
        int classCount = 0; 

        for (int right = 0; right < players.size(); right++) {
            Player rightPlayer = players.get(right);

            // 오른쪽 학생 추가
            if (count[rightPlayer.classNumber] == 0) { 
                classCount++; 
            }
            count[rightPlayer.classNumber]++;

            // 모든 반을 포함하면 왼쪽 줄이기
            while (classCount == N) {
                int diff = players.get(right).ability - players.get(left).ability;
                result = Math.min(result, diff);

                // 왼쪽 학생 제거
                Player leftPlayer = players.get(left);
                count[leftPlayer.classNumber]--;
                if (count[leftPlayer.classNumber] == 0) {
                    classCount--;
                }
                left++;
            }
        }

        System.out.println(result);
    }
}