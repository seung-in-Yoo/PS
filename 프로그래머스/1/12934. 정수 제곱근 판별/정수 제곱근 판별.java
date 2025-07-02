class Solution {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);           
        if (sqrt == (long) sqrt) {            
            long x = (long) sqrt;
            return (x + 1) * (x + 1);          
        } else {
            return -1;
        }
    }
}
