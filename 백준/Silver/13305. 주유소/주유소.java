import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] cost = new int[n];
        int[] dist = new int[n - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        long optimalPrice = Long.MAX_VALUE;
        long current = 0;
        for (int i = 0; i < n - 1; i++) {
            current += Math.min(optimalPrice, cost[i]) * dist[i];
            optimalPrice = Math.min(optimalPrice, cost[i]);
        }

        System.out.println(current);

    }
}
