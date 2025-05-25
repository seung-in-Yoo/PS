import java.util.*;

// 모음 5개
// 자음 중 L 1개
// 나머지 자음 20개
// _ 자리에 모음을 넣을 수도, 자음을 넣을 수도 있고
// L이 반드시 최소 1번은 포함되어야 한다는 조건도 고려해야 함.
public class Main {
    static char[] word;
    static long count = 0;
    static final String vowel = "AEIOU"; // 모음
    static int length;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        word = sc.nextLine().toCharArray();
        length = word.length;

        backtrack(0, 0, 0, false, 1L); // 시작 인덱스, 모음 연속, 자음 연속, L 포함 여부, 시작 weight

        System.out.println(count);
    }
    
    // vowelStreak-> 모음연속, consonantStreak-> 자음연속, hasL -> L포함여부
    static void backtrack(int index, int vowelStreak, int consonantStreak, boolean hasL, long weight) {
        if (vowelStreak >= 3 || consonantStreak >= 3) {
            return; // 위배 조건 걸어주기
        }
        if (index == length) {
            if (hasL) count += weight;
            return;
        }

        char ch = word[index];

        if (ch == '_') {
            // 모음 5개
            backtrack(index + 1, vowelStreak + 1, 0, hasL, weight * 5);

            // 자음 'L'
            backtrack(index + 1, 0, consonantStreak + 1, true, weight * 1);

            // 나머지 자음 20개
            backtrack(index + 1, 0, consonantStreak + 1, hasL, weight * 20);
            
        } else {
            boolean isVowel = vowel.indexOf(ch) >= 0;
            boolean isL = ch == 'L'; // 현재 문자가 L인가?

            if (isVowel) { // 모음일 경우
                backtrack(index + 1, vowelStreak + 1, 0, hasL, weight);
            } else { // 자음일 경우 
                backtrack(index + 1, 0, consonantStreak + 1, hasL || isL, weight);
            }
        }
    }
}
