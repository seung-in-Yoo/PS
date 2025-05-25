import java.util.*;

public class Main {
    static int H, W, N;
    static int[][] sticker;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        N = sc.nextInt();

        sticker = new int[N][2];
        for (int i = 0; i < N; i++) {
            sticker[i][0] = sc.nextInt();
            sticker[i][1] = sc.nextInt();
        }

        int maxArea = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int[] a = sticker[i];
                int[] b = sticker[j];

                int[][] rotationA = {
                    {a[0], a[1]},
                    {a[1], a[0]}
                };

                int[][] rotationB = {
                    {b[0], b[1]},
                    {b[1], b[0]}
                };

                for (int[] aa : rotationA) {
                    for (int[] bb : rotationB) {
                        int h1 = aa[0], w1 = aa[1];
                        int h2 = bb[0], w2 = bb[1];

                        if (Math.max(h1, h2) <= H && (w1 + w2) <= W) {
                            maxArea = Math.max(maxArea, h1 * w1 + h2 * w2);
                        }

                        if ((h1 + h2) <= H && Math.max(w1, w2) <= W) {
                            maxArea = Math.max(maxArea, h1 * w1 + h2 * w2);
                        }
                    }
                }
            }
        }

        System.out.println(maxArea);
    }
}
