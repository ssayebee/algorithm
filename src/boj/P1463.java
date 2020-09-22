import java.io.*;

public class P1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < N + 1; i++) {
            dp[i] = dp[i - 1];
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2]);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3]);
            }
            dp[i]++;
        }

        bw.write(String.valueOf(dp[N]));

        bw.flush();
        bw.close();
    }
}
