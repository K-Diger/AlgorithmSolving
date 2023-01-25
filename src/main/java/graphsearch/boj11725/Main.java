package graphsearch.boj11725;

import java.io.*;
import java.util.*;

// 방문하지 않은 노드라면 visited + 현재 노드를 부모 기록
public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n;
    private static int[][] adjustMatrix;
    private static boolean[][] visited;
    private static final Queue<Pair> queue = new LinkedList<>();
    private static final Map<Integer, Integer> result = new HashMap<>();
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        adjustMatrix = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjustMatrix[a][b] = adjustMatrix[b][a] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            result.put(i, null);
        }

        bfs();

        for (Map.Entry<Integer, Integer> integerIntegerEntry : result.entrySet()) {
            if (integerIntegerEntry.getKey() != 1) {
                bw.write(integerIntegerEntry.getValue() + "\n");
                bw.flush();
            }
        }
        br.close();
        bw.close();
    }

    public static void bfs() {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (adjustMatrix[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                queue.offer(new Pair(i, j));
                while (!queue.isEmpty()) {
                    Pair current = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = current.x + dx[k];
                        int ny = current.y + dy[k];

                        if (nx < 0 || nx >= n + 1 || ny < 0 || ny >= n + 1) {
                            continue;
                        }
                        if (visited[nx][ny] || adjustMatrix[nx][ny] != 1) {
                            continue;
                        }
                        visited[nx][ny] = true;
                        queue.offer(new Pair(nx, ny));
                    }
                    // 인접 행렬 Row의 Column을 순회하면서 어떤 컬럼에서 값이 1이 등장하면
                    // 그 Row는 부모 노드이다.
                    // 그 Column Index는 자식 노드이다.
                    result.put(current.x, current.y);
                }
            }
        }
    }

    static class Pair {
        public int x;
        public int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
