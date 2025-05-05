import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder T = new StringBuilder(br.readLine());

        while (T.length() > S.length()) {
            // 마지막 문자가 A이면 그냥 삭제
            if (T.charAt(T.length() - 1) == 'A') {
                T.deleteCharAt(T.length() - 1);
            }
            // 마지막 문자가 B이면 삭제와 뒤집기
            else if (T.charAt(T.length() - 1) == 'B') {
                T.deleteCharAt(T.length() - 1);
                T.reverse();
            }
        }

        // S와 같아졌는지 확인하기 
        if (T.toString().equals(S)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
