import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long answer = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                arr[i] -= b;
                answer++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                answer += arr[i] / c;
                if (arr[i] % c != 0) {
                    answer++;
                }
            }
        }

        System.out.print(answer);
    }
}
