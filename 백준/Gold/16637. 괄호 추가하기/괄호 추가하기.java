import java.io.*;

public class Main {

    static int N;
    static char[] ops;
    static int[] nums;
    static long max = Long.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String readLine = br.readLine();

        int numCount = (N + 1) / 2;
        nums = new int[numCount];
        ops = new char[numCount - 1];

        int ni = 0, oi = 0;
        for (int i = 0; i < N; i++) {
            char c = readLine.charAt(i);
            if (i % 2 == 0) { 
                nums[ni++] = c - '0';
            }
            else {
                ops[oi++] = c;
            }
        }
        dfs(0, nums[0]);
        System.out.println(max);
    }

    static void dfs(int index, long current) {
        if (index == ops.length) {
            max = Math.max(max, current);
            return;
        }

        long next = calculate(current, ops[index], nums[index + 1]);
        dfs(index + 1, next);

        if (index + 1 < ops.length) {
            long groupValue = calculate(nums[index + 1], ops[index + 1], nums[index + 2]);
            long result = calculate(current, ops[index], groupValue);
            dfs(index + 2, result);
        }
    }

    static long calculate(long a, char op, long b) {
        if (op == '+') {
            return a + b;
        }
        if (op == '-') {
            return a - b;
        }
        return a * b;
    }
}