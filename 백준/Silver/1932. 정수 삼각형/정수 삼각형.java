import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] tri = new int[n][n];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i; j++) {
                tri[i - 1][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = tri[0][0];

        for (int i = 1; i < tri.length; i++) {
            for (int j = 0; j < tri[i].length; j++) {
                if (j == 0) {
                    // 왼쪽 끝
                    dp[i][j] = dp[i - 1][j] + tri[i][j];
                } else if (j == tri[i].length - 1) {
                    // 오른쪽끝
                    dp[i][j] = dp[i - 1][j - 1] + tri[i][j];
                } else {
                    // 중간
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + tri[i][j];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (dp[n - 1][i] > max)
                max = dp[n - 1][i];
        }
        System.out.println(max);
    }
}