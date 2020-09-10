import java.io.*;
import java.util.*;

public class P11448 {

    private static final int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };
    private static final int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };
    private static char[][] map;
    private static int N;
    private static int cnt;

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int k = 0; k < T; k++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            cnt = 0;

            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 'w') {
                        bfs(i, j);
                    }
                }
            }
            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void bfs(int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j));

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            int ci = cur.x;
            int cj = cur.y;

            for (int d = 0; d < dx.length; d++) {
                int ni = ci + dy[d];
                int nj = cj + dx[d];

                if (ni < 0 || ni >= N || nj < 0 || nj >= N || map[ni][nj] != '-')
                    continue;
                cnt++;
                map[ni][nj] = 'w';
                queue.offer(new Point(ni, nj));
            }
        }
    }
}
