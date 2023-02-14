package graphsearch.boj1697_not_solved;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static Queue<int[]> queue = new LinkedList<>();
    private static boolean[] visited;
    private static int[] direction = {2, 1, -1};
    private static int n, k;
    private static int count;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[k * 2];
        bfs(n);
    }

    public static void bfs(int start) {
        queue.add(new int[]{start});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int currentCoordinate = queue.poll()[0];
            int nextCoordinate;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    nextCoordinate = currentCoordinate * direction[i];
                } else {
                    nextCoordinate = currentCoordinate + direction[i];
                }
                System.out.println("nextCoordinate = " + nextCoordinate);
                if (!visited[nextCoordinate]) {
                    count++;
                    visited[nextCoordinate] = true;
                    queue.add(new int[]{nextCoordinate});
                }
            }
        }
    }
}