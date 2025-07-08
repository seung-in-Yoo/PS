// 약수의 개수가 홀수 => 제곱수 
class Solution {
    public int solution(int left, int right) {
        int result = 0;

        for (int i = left; i <= right; i++) {
            if (isSquare(i)) {
                result -= i; 
            } else {
                result += i; 
            }
        }

        return result;
    }

    private boolean isSquare(int num) {
        int sqrt = (int)Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
