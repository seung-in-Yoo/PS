import java.util.*;

class Main {
    static char[] chars;
    static int L, C;
    static boolean[] vowel = new boolean[26];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        L = scanner.nextInt(); // 암호 길이 
        C = scanner.nextInt(); // 사용 문자 개수 
        chars = new char[C];

        for (int i = 0; i < C; i++) {
            chars[i] = scanner.next().charAt(0);
        }

        vowel['a' - 'a'] = true;
        vowel['e' - 'a'] = true;
        vowel['i' - 'a'] = true;
        vowel['o' - 'a'] = true;
        vowel['u' - 'a'] = true;

        Arrays.sort(chars); // 입력받은 문자들 정렬시키기

        backtrack(new char[L], 0, 0, 0, 0);
    }

    // 백트래킹 함수 사용 
    static void backtrack(char[] password, int idx, int vowelCount, int consonantCount, int start) {
        if (idx == L) {
            // 모음 1개 이상, 자음 2개 이상일 때
            if (vowelCount >= 1 && consonantCount >= 2) {
                System.out.println(new String(password));
            }
            return;
        }

        for (int i = start; i < C; i++) {
            password[idx] = chars[i]; 
            if (vowel[chars[i] - 'a']) { // 모음일 경우
                backtrack(password, idx + 1, vowelCount + 1, consonantCount, i + 1);
            } else { // 자음일 경우
                backtrack(password, idx + 1, vowelCount, consonantCount + 1, i + 1);
            }
        }
    }
}
