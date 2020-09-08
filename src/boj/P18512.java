package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P18512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int P1 = Integer.parseInt(st.nextToken());
        int P2 = Integer.parseInt(st.nextToken());
        int result = -1;

        while (true) {
            if (P1 > P2) {
                P2 += Y;
            } else {
                P1 += X;
            }
            if (P1 > 10000 || P2 > 10000) {
                break;
            }
            if (P1 == P2) {
                result = P1;
                break;
            }
        }

        bw.write(result + "");

        bw.flush();
        bw.close();
    }
}
