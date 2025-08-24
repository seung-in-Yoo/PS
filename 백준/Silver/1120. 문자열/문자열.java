import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int aLength = A.length();
        int bLength = B.length();
        int minDiff = Integer.MAX_VALUE; // 최소 차이 

        
        for (int i = 0; i <= bLength - aLength; i++) {
            int diff = 0;
            for (int j = 0; j < aLength; j++) {
                if (A.charAt(j) != B.charAt(i + j)) {
                    diff++;
                }
            }
            minDiff = Math.min(minDiff, diff);
        }

        System.out.println(minDiff);
    }
}