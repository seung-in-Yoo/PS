import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> treeMap = new HashMap<>();
        String tree;
        int total = 0; 

        while ((tree = br.readLine()) != null) {
            treeMap.put(tree, treeMap.getOrDefault(tree, 0) + 1);
            total++; 
        }

        List<String> treeList = new ArrayList<>(treeMap.keySet());
        Collections.sort(treeList); 
        for (String name : treeList) {
            int count = treeMap.get(name);
            double per = (count * 100.0) / total;
            System.out.printf("%s %.4f\n", name, per);
        }
    }
}