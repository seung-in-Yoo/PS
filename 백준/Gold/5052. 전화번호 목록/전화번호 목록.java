import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];

            for (int i=0; i<n; i++) {
                arr[i] = br.readLine().trim();
            }

            Arrays.sort(arr);

            boolean cons = true;
            for (int i=0; i<n-1; i++) {
                if (arr[i + 1].startsWith(arr[i])) {
                    cons = false;
                    break;
                }
            }

            if (cons) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append('\n');
            }

        System.out.print(sb);
    }
}
