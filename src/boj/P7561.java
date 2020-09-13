import java.io.*;
import java.util.*;

public class P7561 {

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    private static final int[] dx = { -1, 1, 2, 2, 1, -1, -2, -2 };
    private static final int[] dy = { -2, -2, -1, 1, 2, 2, 1, -1 };
    private static char[][] map;
    private static int l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            l = Integer.parseInt(br.readLine());
            map = new char[l][l];
            st = new StringTokenizer(br.readLine());
            int ci = Integer.parseInt(st.nextToken());
            int cj = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int ti = Integer.parseInt(st.nextToken());
            int tj = Integer.parseInt(st.nextToken());

            bw.write(bfs(ci, cj, ti, tj) + "\n");

        }

        bw.flush();
        bw.close();
    }

    private static int bfs(int i, int j, int ti, int tj) {
        int dist = 0;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));
        map[i][j] = '1';

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                Point cur = q.poll();
                int ci = cur.x;
                int cj = cur.y;
                if (ci == ti && cj == tj)
                    return dist;

                for (int d = 0; d < dx.length; d++) {
                    int ni = ci + dy[d];
                    int nj = cj + dx[d];

                    if (ni < 0 || ni >= l || nj < 0 || nj >= l || map[ni][nj] == '1')
                        continue;
                    map[ni][nj] = '1';
                    q.offer(new Point(ni, nj));
                }
            }
            dist++;
        }
        return -1;
    }
}
