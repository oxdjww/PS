import java.io.*;
import java.util.*;

public class Main {

    private static int[] arr;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(arr[i], max);
        }

        int answer = Integer.MAX_VALUE;
        int start = max;
        int end = sum;

        while (start <= end) {
            int mid = (start + end) / 2;

            int blue = foo(mid);

            if (blue <= m) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static int foo(int value) {
        int sum = 0;
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > value) {
                count++;
                sum = 0;
            }
            sum += arr[i];

        }
        return count;
    }
}
