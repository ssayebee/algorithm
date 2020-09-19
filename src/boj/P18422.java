import java.io.*;
import java.util.*;

class P18422 {

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
    private static boolean[][] visited;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '*' && !visited[i][j]) {
                    bfs(i, j);
                    result++;
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
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int ci = cur.x;
            int cj = cur.y;

            for (int d = 0; d < di.length; d++) {
                int ni = ci + di[d];
                int nj = cj + dj[d];

                if (ni < 0 || ni >= N || nj < 0 || nj >= M || map[ni][nj] == '.' || visited[ni][nj])
                    continue;
                visited[ni][nj] = true;
                q.offer(new Point(ni, nj));
            }
        }

    }

}
