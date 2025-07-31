import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int[] count = new int[26]; // A부터 Z까지 카운트하는 배열 
        
        for (char c : name.toCharArray()) {
            count[c - 'A']++;
        }
        
        
        int odd = 0;
        int midIndex = -1;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                odd++;
                midIndex = i;
            }
        }
        
        if (odd > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        
        // 절반 조립하고 reverse 하기 
        StringBuilder half = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i] / 2; j++) {
                half.append((char)('A' + i));
            }
        }
        
        StringBuilder result = new StringBuilder();
        result.append(half);
        if (midIndex != -1) { // 홀수 개의 문자가 있을 때
            result.append((char)('A' + midIndex));
        }
        result.append(half.reverse());
        
        System.out.println(result.toString());
    }
}
