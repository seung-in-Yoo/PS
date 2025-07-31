import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> result = new ArrayList<>();
        
        int reset = -1; 
        
        for (int n : arr) {
            if (n != reset) {
                result.add(n);
                reset = n;
            }
        }
        
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
