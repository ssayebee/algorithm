import java.io.*;
import java.util.*;

public class P17198 {

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int N = 10;
    private static final int[] di = { 1, 0, -1, 0 };
    private static final int[] dj = { 0, 1, 0, -1 };
    private static char[][] map;
    private static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new char[N][N];
        dist = new int[N][N];
        int result = -1;

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'B') {
                    result = bfs(i, j);
                }
            }
        }

        bw.write(String.valueOf(result - 1));

        bw.flush();
        bw.close();
    }

    private static int bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));
        boolean isFind = false;
        int result = -1;

        dist[i][j] = 1;
        while (!q.isEmpty() && !isFind) {
            Point cur = q.poll();
            int ci = cur.x;
            int cj = cur.y;

            for (int d = 0; d < di.length; d++) {
                int ni = ci + di[d];
                int nj = cj + dj[d];

                if (ni < 0 || ni >= N || nj < 0 || nj >= N || map[ni][nj] == 'R' || dist[ni][nj] != 0)
                    continue;
                if (map[ni][nj] == 'L') {
                    isFind = true;
                    result = dist[ci][cj];
                    break;
                }
                dist[ni][nj] = dist[ci][cj] + 1;
                q.offer(new Point(ni, nj));
            }
        }
        return result;
    }
}
