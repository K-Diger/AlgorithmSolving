package graphsearch.boj16173;

import java.io.*;
import java.util.StringTokenizer;

public class MainDFS {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] graph;
    private static boolean[][] visited;
    // 오른쪽, 밑
    private static int[] dx = {1, 0};
    private static int[] dy = {0, 1};
    private static int n;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        bw.write("Hing");
        bw.flush();
    }

    private static void dfs(int x, int y) throws IOException {
        visited[x][y] = true;
        for (int i = 0; i < 2; i++) {
            int nextX = x + dx[i] * graph[x][y];
            int nextY = y + dy[i] * graph[x][y];

            if (nextX == n - 1 && nextY == n - 1) {
                bw.write("HaruHaru");
                bw.flush();
                System.exit(0);
            }

            if (nextX < n && nextY < n) {
                if (!visited[nextX][nextY]) {
                    dfs(nextX, nextY);
                }
            }
        }
    }
}
