import java.io.*;
import java.util.*;

public class P3187 {

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[] di = { 1, 0, -1, 0 };
    private static final int[] dj = { 0, 1, 0, -1 };
    private static char[][] map;
    private static int R;
    private static int C;
    private static int totalWolf;
    private static int totalSheep;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#') {
                    bfs(i, j);
                }
            }
        }

        bw.write(totalSheep + " " + totalWolf);

        bw.flush();
        bw.close();
    }

    private static void bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        int wolf = 0;
        int sheep = 0;
        if (map[i][j] == 'v') {
            wolf++;
        } else if (map[i][j] == 'k') {
            sheep++;
        }
        map[i][j] = '#';

        q.offer(new Point(i, j));

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int ci = cur.x;
            int cj = cur.y;

            for (int d = 0; d < di.length; d++) {
                int ni = ci + di[d];
                int nj = cj + dj[d];

                if (ni < 0 || ni >= R || nj < 0 || nj >= C || map[ni][nj] == '#')
                    continue;

                if (map[ni][nj] == 'v') {
                    wolf++;
                } else if (map[ni][nj] == 'k') {
                    sheep++;
                }
                map[ni][nj] = '#';
                q.offer(new Point(ni, nj));
            }
        }
        if (sheep > wolf) {
            totalSheep += sheep;
        } else {
            totalWolf += wolf;
        }
    }
}
