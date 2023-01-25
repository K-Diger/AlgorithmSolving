package graphsearch.boj1260;

import java.io.*;
import java.util.*;


public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n;
    private static int m;
    private static int start;
    private static List<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        for (int i = 1; i < n + 1; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[n + 1];
        dfs(start);
        bw.write("\n");
        bw.flush();

        visited = new boolean[n + 1];
        bfs(start);
        bw.write("\n");
        bw.flush();
    }

    private static void dfs(int start) throws IOException {
        visited[start] = true;
        bw.write(start + " ");
        bw.flush();
        for (int current : graph[start]) {
            if (!visited[current]) {
                dfs(current);
            }
        }
    }

    private static void bfs(int start) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            bw.write(current + " ");
            bw.flush();
            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}