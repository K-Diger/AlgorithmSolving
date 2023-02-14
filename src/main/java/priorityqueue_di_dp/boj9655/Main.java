package priorityqueue_di_dp.boj9655;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        if (n % 2 == 0) {
            bw.write("CY");
        } else {
            bw.write("SK");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
