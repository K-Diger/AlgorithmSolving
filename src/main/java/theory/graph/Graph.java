package theory.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Graph {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visited;

    public static void printDirectedGraphByAdjustMatrix() throws IOException {
        int[][] adj_matrix = new int[10][10];

        // 정점 갯수
        int v = Integer.parseInt(br.readLine());

        // 간선 갯수
        int e = Integer.parseInt(br.readLine());

        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            adj_matrix[u][v] = 1;
        }

        for (int[] adjMatrix : adj_matrix) {
            for (int matrix : adjMatrix) {
                System.out.print(matrix + " ");
            }
            System.out.println();
        }
    }

    public static void printUndirectedGraphByAdjustMatrix() throws IOException {
        int[][] adj_matrix = new int[10][10];

        // 정점
        int v = Integer.parseInt(br.readLine());
        // 간선
        int e = Integer.parseInt(br.readLine());

        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            adj_matrix[u][v] = 1;
            adj_matrix[v][u] = 1;
        }

        for (int[] adjMatrix : adj_matrix) {
            for (int matrix : adjMatrix) {
                System.out.print(matrix + " ");
            }
            System.out.println();
        }
    }

//    public static void printUndirectedGraphByAdjustList() throws IOException {
//        List<Integer> adj = new ArrayList<>();
//
//        // 정점
//        int v = Integer.parseInt(br.readLine());
//        // 간선
//        int e = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < e; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int u = Integer.parseInt(st.nextToken());
//            v = Integer.parseInt(st.nextToken());
//            adj.add();
//            adj_matrix[v][u] = 1;
//        }
//    }


    public static void main(String[] args) throws IOException {
        printDirectedGraphByAdjustMatrix();
        System.out.println("---");
        printUndirectedGraphByAdjustMatrix();
        System.out.println("---");
    }


    public static void bfs(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        visited[start] = true;

        while (!deque.isEmpty()) {
            int node = deque.poll();
            System.out.print(node + " ");
        }
    }
}

