import java.util.*;

class Solution {
    public long solution(long n) {
        String str = Long.toString(n);

        char[] chars = str.toCharArray();

        Arrays.sort(chars);

        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }

        return Long.parseLong(sb.toString());
    }
}