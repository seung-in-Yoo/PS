class Solution {
    public String solution(String my_string) {
        StringBuilder result = new StringBuilder();

        for (char c : my_string.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                continue;
            }
            result.append(c);
        }

        return result.toString();
    }
}
