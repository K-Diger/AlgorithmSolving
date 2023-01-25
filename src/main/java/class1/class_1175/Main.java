package class1.class_1175;

import java.io.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int[] alphabet = new int[26];
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                alphabet[s.charAt(i) - 97]++;
            } else {
                alphabet[s.charAt(i) - 65]++;
            }
        }

        int max = -1;
        char ch = '?';

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > max) {
                max = alphabet[i];
                ch = (char) (i + 65);
            } else if (alphabet[i] == max) {
                ch = '?';
            }
        }
        bw.write(ch);
        bw.close();
        br.close();
    }
}
