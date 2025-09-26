import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        int maxVis = 0;

        for (int i = 0; i < n; i++) {
            int vis = 0;

            // 오른쪽 방향
            for (int j = i + 1; j < n; j++) {
                boolean canSee = true;

                for (int k = i + 1; k < j; k++) {
                    double expect = height[i] + (double)(height[j] - height[i]) * (k - i) / (j - i);

                    if (height[k] >= expect) {
                        canSee = false;
                        break;
                    }
                }

                if (canSee) vis++;
            }

            // 왼쪽 방향
            for (int j = i - 1; j >= 0; j--) {
                boolean canSee = true;

                for (int k = i - 1; k > j; k--) {
                    double expect = height[i] + (double)(height[j] - height[i]) * (k - i) / (j - i);

                    if (height[k] >= expect) {
                        canSee = false;
                        break;
                    }
                }

                if (canSee) {
                    vis++;
                }
            }

            maxVis = Math.max(maxVis, vis);
        }

        System.out.println(maxVis);
    }
}
