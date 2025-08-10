import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Map<String,Integer> map = new HashMap<>();
        
        for (int i=0; i<N; i++) {
            String file = br.readLine();
            String ext = file.substring(file.indexOf(".")+1);
            map.put(ext, map.getOrDefault(ext, 0) + 1);
        }
        
        List<String> exts = new ArrayList<>(map.keySet());
        Collections.sort(exts);
        
        StringBuilder sb = new StringBuilder();
        for (String ext: exts) {
            sb.append(ext).append(" ").append(map.get(ext)).append("\n");
        }
        
        System.out.print(sb);
    }
}