package graphsearch.boj2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] visited;
    private static int[][] adjustMatrix;
    private static int count = 0;
    private static int vertex, edge;
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        vertex = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        adjustMatrix = new int[vertex + 1][vertex + 1];
        visited = new boolean[vertex + 1];

        for (int i = 0; i < edge; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            // 무방향 그래프 이므로
            adjustMatrix[a][b] = 1;
            adjustMatrix[b][a] = 1;
        }
        dfs(1);
        System.out.println(count - 1);

        bfs(1);
        System.out.println(count);
    }

    public static void dfs(int start) {
        visited[start] = true;
        count++;
        for (int i = 0; i <= vertex; i++) {
            if (adjustMatrix[start][i] == 1 && !visited[i])
                dfs(i);
        }
    }

    public static void bfs(int start) {
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 1; i < vertex + 1; i++) {
                if (adjustMatrix[current][i] == 1 && visited[i] == false) {
                    queue.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
    }
}
