package graphsearch.boj16173;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class IncorrectMain {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] graph;
    private static boolean[][] visited;
    private static Queue<int[]> queue = new LinkedList<>();
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
        bfs();
        br.close();
        bw.close();
    }

    public static void bfs() throws IOException {
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] currentCoordinate = queue.poll();
            int currentRow = currentCoordinate[0];
            int currentCol = currentCoordinate[1];

            if (currentRow == n - 1 && currentCol == n - 1) {
                bw.write("HaruHaru");
                bw.flush();
                return;
            }

            visited[currentRow][currentCol] = true;

            int jump = graph[currentRow][currentCol];
            int movingRow = currentRow + jump;
            int movingCol = currentCol + jump;

            if (movingRow < n && movingCol < n) {
                if (!visited[movingRow][currentCol]) {
                    queue.add(new int[]{movingRow, currentCol});
                }
                if (!visited[currentRow][movingCol]) {
                    queue.add(new int[]{currentRow, movingCol});
                }
            }

        }
        bw.write("Hing");
        bw.flush();
    }

}
