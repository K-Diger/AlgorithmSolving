package priorityqueue_di_dp.boj14235;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
        Collections.reverseOrder());
    private static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 0) {
                if (priorityQueue.isEmpty()) {
                    bw.write("-1\n");
                    bw.flush();
                } else {
                    bw.write(priorityQueue.poll() + "\n");
                    bw.flush();
                }
            } else {
                for (int j = 0; j < a; j++) {
                    int present = Integer.parseInt(st.nextToken());
                    priorityQueue.offer(present);
                }
            }
        }
    }
}
