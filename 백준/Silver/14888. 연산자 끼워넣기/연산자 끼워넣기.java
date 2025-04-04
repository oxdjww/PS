import java.io.*;
import java.util.*;

public class Main {
    private static long min = Long.MAX_VALUE;
    private static long max = Long.MIN_VALUE;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] oper = new int[4];
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0], arr, oper[0], oper[1], oper[2], oper[3]);
        System.out.print(max + "\n" + min);
    }

    private static void dfs(int idx, long cur, long[] arr, int plus, int minus, int mult, int div) {
        if (idx == n) {
            min = Math.min(min, cur);
            max = Math.max(max, cur);
            return;
        }

        if (plus > 0) {
            dfs(idx + 1, cur + arr[idx], arr, plus - 1, minus, mult, div);
        }
        if (minus > 0) {
            dfs(idx + 1, cur - arr[idx], arr, plus, minus - 1, mult, div);
        }
        if (mult > 0) {
            dfs(idx + 1, cur * arr[idx], arr, plus, minus, mult - 1, div);
        }
        if (div > 0) {
            long result = 0;
            if (cur < 0) {
                result = -(Math.abs(cur) / arr[idx]);
            } else {
                result = cur / arr[idx];
            }
            dfs(idx + 1, result, arr, plus, minus, mult, div - 1);
        }
    }
}
