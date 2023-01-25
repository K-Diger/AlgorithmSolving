package graphsearch.boj1012;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] graph;
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    private static boolean[][] visited;
    private static int t, m, n, k;
    private static Queue<int[]> queue = new LinkedList<>();
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // -> Number of Column
            n = Integer.parseInt(st.nextToken()); // -> Number of Row
            k = Integer.parseInt(st.nextToken()); // -> Number of Cabbage
            graph = new int[n][m];
            visited = new boolean[n][m];
            count = 0;
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y][x] = 1;
            }
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (graph[r][c] == 1 && !visited[r][c]) {
                        bfs(r, c);
                        count++;
                    }
                }
            }
            bw.write(String.valueOf(count) + "\n");
            bw.flush();
        }
        br.close();
        bw.close();
    }

    public static void bfs(final int x, final int y) {
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && graph[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}