import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int MAX = 1000000;
        int[] nums = new int[N];
        int[] score = new int[N];
        int[] pos = new int[MAX + 1]; 

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            pos[nums[i]] = i + 1; 
        }

       
        for (int i = 0; i < N; i++) {
            int x = nums[i];
            for (int m = x * 2; m <= MAX; m += x) {
                if (pos[m] > 0) { 
                    score[i]++;           
                    score[pos[m] - 1]--;  
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int s : score) {
            sb.append(s).append(" ");
        }
        
        System.out.println(sb.toString().trim());
    }
}