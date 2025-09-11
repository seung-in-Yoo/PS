import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nickMap = new HashMap<>(); 
        List<String[]> logs = new ArrayList<>(); 

        for (String r : record) {
            String[] parts = r.split(" ");
            String action = parts[0];
            String uid = parts[1];

            if (action.equals("Enter") || action.equals("Change")) {
                String nickname = parts[2];
                nickMap.put(uid, nickname);
            }

            if (action.equals("Enter") || action.equals("Leave")) {
                logs.add(new String[]{uid, action});
            }
        }

       
        List<String> answer = new ArrayList<>();
        for (String[] log : logs) {
            String uid = log[0];
            String action = log[1];
            String nickname = nickMap.get(uid);

            if (action.equals("Enter")) {
                answer.add(nickname + "님이 들어왔습니다.");
            } else {
                answer.add(nickname + "님이 나갔습니다.");
            }
        }

        return answer.toArray(new String[0]);
    }
}