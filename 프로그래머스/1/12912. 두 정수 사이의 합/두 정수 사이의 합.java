class Solution {
    public long solution(int a, int b) {
        long total = 0;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        
        for (int i = min; i <= max; i++) {
            total += i;
        }

        return total;
    }
}
