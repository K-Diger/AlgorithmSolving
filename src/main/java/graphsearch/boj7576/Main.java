package graphsearch.boj7576;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] board;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int n;
    private static int m;
    private static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        bw.write(String.valueOf(bfs()));
        bw.flush();
    }

    private static int bfs() {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (board[nx][ny] == 0) {
                    board[nx][ny] = board[currentX][currentX] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        if (checkEndFlag()) {
            return -1;
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (max < board[i][j]) {
                        max = board[i][j];
                    }
                }
            }
            return max;
        }
    }

    private static boolean checkEndFlag() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0)
                    return true;
            }
        }
        return false;
    }
}

