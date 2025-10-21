import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<int[]> assign = new ArrayList<>();
        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            int w = sc.nextInt();
            assign.add(new int[]{d, w});
            maxDeadline = Math.max(maxDeadline, d);
        }

        assign.sort((a, b) -> b[1] - a[1]); 

        boolean[] isScheduled = new boolean[maxDeadline + 1];

        int total = 0;

        for (int[] t : assign) {
            int deadline = t[0];
            int score = t[1];

            for (int i = deadline; i >= 1; i--) {
                if (!isScheduled[i]) {
                    isScheduled[i] = true;
                    total += score;
                    break;
                }
            }
        }

        System.out.println(total);
    }
}
