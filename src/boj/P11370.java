package boj;

import java.io.*;
import java.util.*;

class P11370 {

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    private static final int[] dx = { 1, 0, -1, 0 };
    private static final int[] dy = { 0, 1, 0, -1 };
    private static char[][] map;
    private static boolean[][] visited;
    private static int H;
    private static int W;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] s = br.readLine().split(" ");

            W = Integer.parseInt(s[0]);
            H = Integer.parseInt(s[1]);

            if (W == 0 && H == 0)
                break;

            map = new char[H][W];
            visited = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                map[i] = br.readLine().trim().toCharArray();
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (!visited[i][j] && map[i][j] == 'S') {
                        bfs(i, j);
                    }
                }
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    bw.write(map[i][j]);
                }
                bw.write("\n");
            }
        }

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
            map[ci][cj] = 'S';

            for (int d = 0; d < dx.length; d++) {
                int ni = ci + dy[d];
                int nj = cj + dx[d];

                if (ni >= 0 && ni < H && nj >= 0 && nj < W && map[ni][nj] != '.' && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    q.offer(new Point(ni, nj));
                }
            }
        }
    }
}
