import java.io.*;

public class P17198 {

    private static final int N = 10;
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int li = 0;
        int lj = 0;
        int bi = 0;
        int bj = 0;
        int ri = 0;
        int rj = 0;

        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'L') {
                    li = i;
                    lj = j;
                }
                if (map[i][j] == 'B') {
                    bi = i;
                    bj = j;
                }
                if (map[i][j] == 'R') {
                    ri = i;
                    rj = j;
                }
            }
        }
        if (li == bi && li == ri) {
            bw.write(Math.abs(li - bi) + Math.abs(lj - bj) + 1 + "");
        } else if (lj == bi && lj == rj) {
            bw.write(Math.abs(lj - bi) + Math.abs(lj - bj) + 1 + "");
        } else {
            bw.write(Math.abs(li - bi) + Math.abs(lj - bj) - 1 + "");
        }

        bw.flush();
        bw.close();
    }
}
