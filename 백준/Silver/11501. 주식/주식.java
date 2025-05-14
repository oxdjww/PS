import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testcase; t++) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long answer = 0;
            long max = Long.MIN_VALUE;
            for (int i = n - 1; i >= 0; i--) {
                int current = arr[i];
                max = Math.max(max, current);

                if (current < max) {
                    answer += max - current;
                }
            }

            sb.append(String.valueOf(answer));
            if (t != testcase - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
