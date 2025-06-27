import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        Set<String> set = new HashSet<>();
        int count = 0;

        for (String str : s1) {
            set.add(str);
        }

        for (String str : s2) {
            if (set.contains(str)) {
                count++;
            }
        }

        return count;
    }
}
