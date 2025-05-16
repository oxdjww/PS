import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] positive = new long[10_000_001];
        long[] negative = new long[10_000_001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (number >= 0) {
                positive[number]++;
            } else {
                negative[Math.abs(number)]++;
            }
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int find = Integer.parseInt(st.nextToken());
            if (find >= 0) {
                sb.append(positive[find]);
            } else {
                sb.append(negative[Math.abs(find)]);
            }
            if (i != m - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb);
    }
}
