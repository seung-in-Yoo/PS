class Solution {
    boolean solution(String s) {
        s = s.toLowerCase(); 
        int pCount = 0;
        int yCount = 0;

        for (char c : s.toCharArray()) {
            if (c == 'p') { pCount++; }
            else if (c == 'y') { yCount++; }
        }

        return pCount == yCount;
    }
}
