import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line[j];
            }
        }

        int len = Math.min(arr.length, arr[0].length) - 1;

        for (int t = len; t >= 0; t--) {
            for (int i = 0; i < arr.length - t; i++) {
                for (int j = 0; j <= m - t - 1; j++) {
                    if (arr[i][j] == arr[i][j + t]
                            && arr[i][j + t] == arr[i + t][j + t]
                            && arr[i + t][j + t] == arr[i + t][j]) {
                        System.out.println((int) Math.pow(t + 1, 2));
                        return;
                    }
                }
            }
        }
    }
}
