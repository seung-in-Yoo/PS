class Solution {
    public long solution(int price, int money, int count) {
        long totalPrice = (long)price * count * (count + 1) / 2; // 등차수열 공식 사용 

        long shortage = totalPrice - money;
        return shortage > 0 ? shortage : 0;
    }
}