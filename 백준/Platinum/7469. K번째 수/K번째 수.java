import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, length = 0;

        private int readByte() throws IOException {
            if (ptr >= length) {
                length = in.read(buffer);
                ptr = 0;
                if (length <= 0) { return -1; }
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do c = readByte();
            while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = readByte();
            }

            int value = 0;
            while (c > ' ') {
                value = value * 10 + (c - '0');
                c = readByte();
            }
            return value * sign;
        }
    }

    static int n, m;
    static int[] a;                 
    static int[] sortValues; // 이분 탐색용 값 
    static int[][] tree;            

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder sb = new StringBuilder();

        n = fs.nextInt();
        m = fs.nextInt();

        a = new int[n];
        sortValues = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
            sortValues[i] = a[i];
        }

        Arrays.sort(sortValues);

        // 세그먼트 트리 크기와 노드별 배열은 build에서 생성하도록 
        tree = new int[4 * n][];
        build(1, 0, n - 1);

        for (int qi = 0; qi < m; qi++) {
            int i = fs.nextInt() - 1; 
            int j = fs.nextInt() - 1;
            int k = fs.nextInt();

            int answer = kthNumber(i, j, k);
            sb.append(answer).append('\n');
        }

        System.out.print(sb);
    }

    static void build(int node, int l, int r) {
        if (l == r) {
            tree[node] = new int[]{a[l]};
            return;
        }

        int mid = (l + r) >>> 1;
        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // 두 정렬 배열 병합
    static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) { merged[k++] = left[i++]; }
            else { merged[k++] = right[j++]; }
        }
        while (i < left.length) { merged[k++] = left[i++]; }
        while (j < right.length) { merged[k++] = right[j++]; }

        return merged;
    }

    static int countLandE(int node, int l, int r, int ql, int qr, int x) {
        if (qr < l || r < ql) return 0;          
        if (ql <= l && r <= qr) {
            return upperBound(tree[node], x);
        }

        int mid = (l + r) >>> 1;
        return countLandE(node * 2, l, mid, ql, qr, x) 
            + countLandE(node * 2 + 1, mid + 1, r, ql, qr, x);
    }

    // x 이하 원소 개수 
    static int upperBound(int[] arr, int x) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] <= x) { lo = mid + 1; }
            else { hi = mid; }
        }
        return lo;
    }

    static int kthNumber(int l, int r, int k) {
        int lo = 0;
        int hi = n - 1;

        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            int x = sortValues[mid];

            int count = countLandE(1, 0, n - 1, l, r, x);

            if (count >= k) { hi = mid; }      
            else { lo = mid + 1; }           
        }

        return sortValues[lo];
    }
}
