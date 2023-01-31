package graphsearch.boj7576;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] graph;
    private static boolean[][] visited;
    private static final int[] directionX = {-1, 1, 0, 0};
    private static final int[] directionY = {0, 0, -1, 1};
    private static int n;
    private static int m;
    private static final Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // Column
        n = Integer.parseInt(st.nextToken()); // Row

        graph = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        if (checkEndFlag()) {

        } else {
            bw.write("-1");
            bw.flush();
        }

        for (int[] ints : graph) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static void bfs(int x, int y) {
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + directionX[i];
                int nextY = currentY + directionY[i];

                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                    if (graph[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        graph[nextX][nextY] = graph[nextX][nextY] + 1;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }

    private static boolean checkEndFlag() {
        int day = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    return false;
                } else {
                    day = Math.max(day, graph[i][j]);
                }
            }
        }
        return true;
    }
}