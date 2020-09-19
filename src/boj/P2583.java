import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class P2583 {

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
    private static boolean[][] map;
    private static int M;
    private static int N;
    private static int K;
    private static ArrayList<Integer> list;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[M][N];
        list = new ArrayList<>();
        cnt = 0;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    map[j][k] = true;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!map[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        list.sort(Comparator.naturalOrder());
        sb.append(cnt).append("\n");
        sb.append(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));
        map[i][j] = true;
        int count = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int ci = cur.x;
            int cj = cur.y;
            count++;

            for (int d = 0; d < di.length; d++) {
                int ni = ci + di[d];
                int nj = cj + dj[d];

                if (ni < 0 || ni >= M || nj < 0 || nj >= N || map[ni][nj])
                    continue;
                map[ni][nj] = true;
                q.offer(new Point(ni, nj));
            }
        }
        list.add(count);
    }
}
