package graphsearch.boj4963;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] graph;
    private static boolean[][] visited;
    private static final int[] directionX = {0, 0, -1, 1, 1, -1, -1, 1};
    private static final int[] directionY = {-1, 1, 0, 0, 1, -1, 1, -1};
    private static Queue<int[]> queue = new LinkedList<>();
    private static int w;
    private static int h;
    private static int count;

    public static void main(String[] args) throws IOException {
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            count = 0;
            if (w == 0 && h == 0) {
                break;
            }
            graph = new int[h][w];
            visited = new boolean[h][w];
            queue = new LinkedList<>();
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (graph[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            bw.write(String.valueOf(count) + "\n");
        }
        bw.close();
        br.close();
    }

    private static void bfs(int x, int y) {
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 8; i++) {
                int nextX = currentX + directionX[i];
                int nextY = currentY + directionY[i];

                if (nextX >= 0 && nextY >= 0 && nextX < h && nextY < w) {
                    if (!visited[nextX][nextY] && graph[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }
}
