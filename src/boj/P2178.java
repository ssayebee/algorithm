import java.io.*;
import java.util.*;

public class P2178 {

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

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        bw.write(String.valueOf(bfs()));

        bw.flush();
        bw.close();
    }

    private static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        int dist = 0;
        visited[0][0] = true;

        while (!q.isEmpty()) {
            dist++;
            int size = q.size();
            while (size-- > 0) {
                Point cur = q.poll();
                int ci = cur.x;
                int cj = cur.y;
                if (ci == N - 1 && cj == M - 1)
                    return dist;

                for (int d = 0; d < di.length; d++) {
                    int ni = ci + di[d];
                    int nj = cj + dj[d];

                    if (ni < 0 || ni >= N || nj < 0 || nj >= M || visited[ni][nj] || map[ni][nj] == '0')
                        continue;
                    visited[ni][nj] = true;
                    q.offer(new Point(ni, nj));
                }
            }
        }
        return -1;
    }
}
