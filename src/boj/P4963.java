import java.io.*;
import java.util.*;

public class P4963 {

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    private static final int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };
    private static final int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };
    private static char[][] map;
    private static int h;
    private static int w;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            cnt = 0;
            if (w == 0 && h == 0)
                break;
            map = new char[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = st.nextToken().charAt(0);
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == '1') {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            bw.write(cnt + "\n");

        }

        bw.flush();
        bw.close();
    }

    private static void bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));
        map[i][j] = '0';

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int ci = cur.x;
            int cj = cur.y;

            for (int d = 0; d < dx.length; d++) {
                int ni = ci + dy[d];
                int nj = cj + dx[d];

                if (ni < 0 || ni >= h || nj < 0 || nj >= w || map[ni][nj] == '0')
                    continue;
                map[ni][nj] = '0';
                q.offer(new Point(ni, nj));
            }
        }
    }
}
