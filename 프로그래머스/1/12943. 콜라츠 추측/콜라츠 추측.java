class Solution {
    public int solution(int num) {
        long n = num; // 형 변환 해줘야함 
        int count = 0;

        while (n != 1) {
            if (count == 500) { return -1; }

            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }

            count++;
        }

        return count;
    }
}