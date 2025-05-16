import java.io.*;
import java.util.*;

// 차량의 진입보다 출구로 나온 순서가 더 빠르다면 추월한것임 
// 뒤에 있어야 할 차량이 앞에 나왔다면 추월
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 차량 N대

        Map<String, Integer> entry = new HashMap<>(); // 입구
        String[] exit = new String[N]; // 출구 

        // 입구 순서 저장
        for (int i = 0; i < N; i++) {
            String car = br.readLine();
            entry.put(car, i); // 차량번호: key, 들어온 순서: value 저장 
        }

        // 출구 순서 저장
        for (int i = 0; i < N; i++) {
            exit[i] = br.readLine();
        }

        // 출구 순서를 입구의 인덱스 순서로 변환하고 
        int[] exitIndex = new int[N];
        for (int i = 0; i < N; i++) {
            exitIndex[i] = entry.get(exit[i]);
        }

        // 앞 차량이 뒤 차량보다 나중에 진입했다면 추월 한거임 
        int overtake = 0; // 추월 차량 
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (exitIndex[i] > exitIndex[j]) {
                    overtake++; // i번째 출구의 차량이 j번째 차량보다 늦게 들어오면 추월카운트++
                    break; 
                }
            }
        }

        System.out.println(overtake);
    }
}
