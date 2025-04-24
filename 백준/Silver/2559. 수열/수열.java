import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long[] acc = new long[n];
        acc[0] = arr[0];
        for (int i = 1; i < n; i++) {
            acc[i] = arr[i] + acc[i - 1];
            // System.out.println("acc[" + i + "] = " + acc[i]);
        }
        long answer = Long.MIN_VALUE;
        for (int left = 0, right = left + k - 1; right < n;) {
            long diff = acc[right] - (left > 0 ? acc[left - 1] : 0);
            // System.out.println(left + "~" + right + " diff: " + diff);
            answer = Math.max(answer, diff);
            left++;
            right++;
        }
        System.out.println(answer);

    }
}