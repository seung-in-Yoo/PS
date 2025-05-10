import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int scenario = 1;
        
        while(true) {
            String line = br.readLine();
            
            if (line == null || line.equals("0")) {
                break;
            }
            
            int n = Integer.parseInt(line); // 압수된 여학생의 수 
            
            String[] names = new String[n+1];
            for(int i=1; i<=n; i++) {
                names[i] = br.readLine(); // 여학생들의 이름을 저장
            }
            
            int[] count = new int[n+1]; // 번호 등장 횟수 저장
            
            for (int i=0; i<2*n-1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                count[num]++;
            }
            
            int correct = -1; // 정답(귀걸이 돌려받지 못한 여학생)
            for (int i = 1; i <= n; i++) {
                if (count[i] == 1) {
                    correct = i;
                    break;
                }
            }
            
            sb.append(scenario).append(" ").append(names[correct]).append("\n");
            scenario++;
        }
        
        System.out.println(sb);
    }
}