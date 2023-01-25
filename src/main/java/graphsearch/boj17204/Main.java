package graphsearch.boj17204;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int n;
    private static int k;
    private static int[][] adjustMatrix;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        adjustMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            adjustMatrix[i][a] = 1;
            adjustMatrix[a][i] = 1;
        }

        for (int[] matrix : adjustMatrix) {
            System.out.println("matrix = " + Arrays.toString(matrix));
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 1; i < n; i++) {
                if (adjustMatrix[current][i] == 1 && visited[current] == false) {
                    queue.offer(i);
                    visited[i] = true;

                }
            }
        }
    }
}
