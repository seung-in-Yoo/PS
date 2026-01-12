import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Edge>[] tree;
    static int[][] parent;
    static int[] depth;
    static long[] distance;
    static int LOG = 16; 

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        for (int i=1; i<=N; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            tree[a].add(new Edge(b, w));
            tree[b].add(new Edge(a, w));
        }

        parent = new int[LOG + 1][N + 1];
        depth = new int[N + 1];
        distance = new long[N + 1];

        dfs(1, 0, 0);     
        buildParent();  

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(getDistance(u, v)).append('\n');
        }

        System.out.print(sb.toString());
    }

    static void dfs(int current, int par, int d) {
        parent[0][current] = par;
        depth[current] = d;

        for (Edge e : tree[current]) {
            if (e.to != par) {
                distance[e.to] = distance[current] + e.weight;
                dfs(e.to, current, d + 1);
            }
        }
    }

    static void buildParent() {
        for (int k=1; k<=LOG; k++) {
            for (int v = 1; v <= N; v++) {
                parent[k][v] = parent[k-1][ parent[k-1][v] ];
            }
        }
    }

    static long getDistance(int u, int v) {
        int lca = LCA(u, v);
        return distance[u] + distance[v] - 2 * distance[lca];
    }

    static int LCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u; u = v; v = temp;
        }

        for (int k=LOG; k>=0; k--) {
            if (depth[u] - (1 << k) >= depth[v]) {
                u = parent[k][u];
            }
        }

        if (u == v) { return u; }
        for (int k=LOG; k>=0; k--) {
            if (parent[k][u] != parent[k][v]) {
                u = parent[k][u];
                v = parent[k][v];
            }
        }

        return parent[0][u];
    }
}
