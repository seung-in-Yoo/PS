// 카카오 2017 코테 1번 
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            
            int row = arr1[i] | arr2[i]; // 하나라도 벽이면 전체에서도 벽 
            
            // 이진수로 변환하는 코드 
            String makeBinary = Integer.toBinaryString(row);
            while (makeBinary.length() < n) {
                makeBinary = "0" + makeBinary; // n자리로 맞추기 위해 만약에 자리 안맞으면 0 추가 
            }
            
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (makeBinary.charAt(j) == '1') {
                    sb.append("#"); // 1인곳은 #으로 바꾸고 0이면 공백처리
                }
                else { sb.append(" "); }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}