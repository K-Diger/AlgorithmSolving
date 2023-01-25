package class1.class_1008;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw.write(String.valueOf(Double.parseDouble(st.nextToken()) / Double.parseDouble(st.nextToken())));
        bw.flush();
        bw.close();
        br.close();
    }
}
