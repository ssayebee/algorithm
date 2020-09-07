import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P6186 {

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int R;
    private static int C;
    private static final int[] dx = { 0, 1, 0, -1 };
    private static final int[] dy = { 1, 0, -1, 0 };
    private static char[][] place;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[R][C];
        place = new char[R][C];

        int result = 0;

        for (int i = 0; i < R; i++) {
            place[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // found new grass
                if (!visited[i][j] && place[i][j] == '#') {
                    result++;
                    bfs(i, j);
                }
                // passed or not found
                else {
                    visited[i][j] = true;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int ci = cur.x;
            int cj = cur.y;
            for (int n = 0; n < dx.length; n++) {
                int ni = ci + dx[n];
                int nj = cj + dy[n];
                if (ni >= 0 && ni < R && nj >= 0 && nj < C && place[ni][nj] == '#' && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    q.offer(new Point(ni, nj));
                }
            }
        }
    }

}
