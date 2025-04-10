import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][2]; 

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken()); // x
            points[i][1] = Integer.parseInt(st.nextToken()); // y
        }

        // x 오름차순, x가 같으면 y 오름차순
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]); // x가 같으면 y 오름차순
            } else {
                return Integer.compare(a[0], b[0]); // x 오름차순
            }
        });

       
        for (int i = 0; i < N; i++) {
            sb.append(points[i][0]).append(" ").append(points[i][1]).append("\n");
        }

        System.out.print(sb);
    }
}
