import java.util.*;
import java.io.*;

public class Main {
    static class Cow implements Comparable<Cow> {
        int arrival; // 도착 시간
        int checkTime; // 검문 시간
        
        Cow(int arrival, int checkTime) {
            this.arrival = arrival;
            this.checkTime = checkTime;
        }
        
        public int compareTo(Cow c) {
            return this.arrival - c.arrival; // 도착 시간 기준으로 정렬시키기
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 소의 수
        Cow[] cows = new Cow[N]; // 소들을 넣을 배열 생성
        
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arrival = Integer.parseInt(st.nextToken());
            int checkTime = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(arrival, checkTime);
        }
        
        Arrays.sort(cows);
        
        int currentTime = 0; // 현재 시간
        
        for (int i=0; i<N; i++) {
            if (currentTime < cows[i].arrival) {
                currentTime = cows[i].arrival;
            }
            
            currentTime += cows[i].checkTime;
        }
        
        System.out.println(currentTime);
    }
}