class Solution {
    public int solution(int[] numbers) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        
        for (int number:numbers) {
            if (number > max) {
                secondMax = max;
                max = number;
            } else if (number > secondMax) {
                secondMax = number;
            }
        }
        return max*secondMax;
    }
}