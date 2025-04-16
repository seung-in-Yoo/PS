import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 단어 개수
        int count = 0; // 그룹 단어 수

        for (int t = 0; t < N; t++) {
            String word = sc.next();
            if (isGroupWord(word)) {
                count++;
            }
        }

        System.out.println(count); 
    }

    // 그룹 단어인지 확인
    public static boolean isGroupWord(String word) {
        boolean[] visited = new boolean[26]; // 알파벳 방문 여부
        char prev = 0; 

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            // 이전 문자와 다른 경우에만 검사
            if (c != prev) {
                if (visited[c - 'a']) {
                    return false;
                }
                visited[c - 'a'] = true; // 방문 체크
            }

            prev = c; // 현재 문자를 이전 문자로 갱신
        }

        return true; 
    }
}
