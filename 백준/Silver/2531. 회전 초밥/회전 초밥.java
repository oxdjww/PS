import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] var = new int[d + 1];
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int left = 0, right = k - 1;

        for (int i = 0; i < k; i++) {
            if (var[arr[i]] == 0) {
                count++;
            }
            var[arr[i]]++;
        }

        int answer = count + (var[c] == 0 ? 1 : 0);
        for (int i = 0; i < N; i++) {
            right++;
            if (right == N)
                right = 0;
            if (var[arr[right]] == 0) {
                count++;
            }
            var[arr[right]] += 1;

            if (var[arr[left]] == 1) {
                count--;
            }
            var[arr[left]] -= 1;

            left++;

            int temp = count + (var[c] == 0 ? 1 : 0);
            answer = Math.max(answer, temp);
        }

        System.out.println(answer);
    }
}