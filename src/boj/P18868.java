package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P18868 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int result = 0;

        int[][] spaces = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                spaces[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < spaces.length; i++) {
            spaces[i] = toRanked(spaces[i]);
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < spaces.length; i++) {
            String rankKey = Arrays.toString(spaces[i]);
            if (!map.containsKey(rankKey)) {
                map.put(rankKey, 1);
            } else {
                map.put(rankKey, map.get(rankKey) + 1);
            }
        }

        for (int val : map.values()) {
            if (val > 1) {
                for (int i = 1; i < val; i++) {
                    result += i;
                }
            }
        }

        bw.write(result + "");

        bw.flush();
        bw.close();

    }

    public static int[] toRanked(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] copyed = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copyed);
        for (int value : copyed) {
            map.putIfAbsent(value, map.size());
        }
        for (int i = 0; i < arr.length; i++) {
            copyed[i] = map.get(arr[i]);
        }
        return copyed;
    }
}
