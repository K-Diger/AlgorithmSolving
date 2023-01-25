package graphsearch.boj2468;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] adjustMatrix;
    static int count = 0;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        adjustMatrix = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (st.hasMoreTokens()) {
                    adjustMatrix[i][j] = Integer.parseInt(st.nextToken());
                    if (adjustMatrix[i][j] < n) {
                        adjustMatrix[i][j] = 0;
                    } else {
                        adjustMatrix[i][j] = 1;
                    }
                }
            }
        }

        for (int[] matrix : adjustMatrix) {
            System.out.println(Arrays.toString(matrix));
        }
        dfs(0, 0, 0);
        bw.write(String.valueOf(count) + "\n");
        bw.flush();

        for (boolean[] booleans : visited) {
            System.out.println(Arrays.toString(booleans));
        }
    }

    private static void dfs(int x, int y, int depth) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < adjustMatrix.length && ny < adjustMatrix.length) {
                if (adjustMatrix[nx][ny] > depth && !visited[nx][ny]) {
                    dfs(nx, ny, depth);
                }
            }
        }
    }
}
