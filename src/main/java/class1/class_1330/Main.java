package class1.class_1330;


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (a > b) {
            bw.write(">");
            bw.flush();
            bw.close();
            br.close();
        } else if (a < b) {
            bw.write("<");
            bw.flush();
            bw.close();
            br.close();
        } else {
            bw.write("==");
            bw.flush();
            bw.close();
            br.close();
        }
    }
}
