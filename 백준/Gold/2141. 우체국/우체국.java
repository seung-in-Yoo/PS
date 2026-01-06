import java.util.*;
import java.io.*;

public class Main {
    static class Village implements Comparable<Village> {
        long position;
        long people;

        Village(long position, long people) {
            this.position = position;
            this.people = people;
        }

        @Override
        public int compareTo(Village o) {
            return Long.compare(this.position, o.position);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Village[] villages = new Village[N];
        long totalPeople = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            villages[i] = new Village(x, a);
            totalPeople += a;
        }

        Arrays.sort(villages);

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += villages[i].people;
            if (sum >= (totalPeople + 1) / 2) {
                System.out.println(villages[i].position);
                return;
            }
        }
    }
}
