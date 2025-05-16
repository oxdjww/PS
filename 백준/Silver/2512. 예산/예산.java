import java.io.*;
import java.util.*;

public class Main {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int start = 0;
        int m = Integer.parseInt(br.readLine());
        int end = max;

        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            int sum = foo(mid);
            if (sum <= m) {
                answer = Math.max(answer, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(answer);
    }

    private static int foo(int value) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.min(arr[i], value);
        }
        return sum;
    }
}
