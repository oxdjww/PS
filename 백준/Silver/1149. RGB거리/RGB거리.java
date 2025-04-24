import java.util.*;
import java.io.*;

public class Main {

    private static int[][] arr;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][3];

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    int prev = dp[i - 1][0];
                    dp[i][j] = arr[i][j] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                    // System.out.printf("mark %d , %d with %d\n", i, j, dp[i][j]);
                } else if (j == 1) {
                    dp[i][j] = arr[i][j] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                    // System.out.printf("mark %d , %d with %d\n", i, j, dp[i][j]);
                } else {
                    dp[i][j] = arr[i][j] + Math.min(dp[i - 1][0], dp[i - 1][1]);
                    // System.out.printf("mark %d , %d with %d\n", i, j, dp[i][j]);
                }
            }

        }
        System.out.println(
                Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));
    }
}