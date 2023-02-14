package backtracking.boj15649;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] graph;
    private static boolean[] visited;
    private static int n, m;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[m];
        visited = new boolean[n];

        dfs(0);
        bw.write(sb.toString());
        bw.flush();
    }

    public static void dfs(int depth) {
        if (depth == m) {
            for (int i : graph) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                graph[depth] = i + 1;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}