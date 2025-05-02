import java.io.*;
import java.util.*;

public class Main {
    static class Document {
        int index;      // 문서의 원래 위치
        int priority;   // 중요도

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서 수
            int M = Integer.parseInt(st.nextToken()); // 궁금한 문서 위치

            st = new StringTokenizer(br.readLine());
            Queue<Document> queue = new LinkedList<>();
            int[] priorities = new int[10]; 

            for (int i = 0; i < N; i++) {
                int pr = Integer.parseInt(st.nextToken());
                queue.add(new Document(i, pr));
                priorities[pr]++;
            }

            int printOrder = 0;

            while (!queue.isEmpty()) {
                Document current = queue.poll();

                // 뒤에 더 높은 중요도가 있으면 다시 큐에 추가
                boolean hasHigher = false;
                for (int i = current.priority + 1; i <= 9; i++) {
                    if (priorities[i] > 0) {
                        hasHigher = true;
                        break;
                    }
                }

                if (hasHigher) {
                    queue.add(current); 
                } else {
                    printOrder++;
                    priorities[current.priority]--;

                    if (current.index == M) {
                        System.out.println(printOrder);
                        break;
                    }
                }
            }
        }
    }
}
