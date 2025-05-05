import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        int left = 0;
        int right = arr.length - 1;

        Arrays.sort(arr);
        int answer = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];
            // System.out.printf("%d + %d = %d\n", arr[left], arr[right], sum);
            if (sum == x) {
                answer++;
                right--;
                left++;
            } else if (sum < x) {
                left++;
            } else {
                right--;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
