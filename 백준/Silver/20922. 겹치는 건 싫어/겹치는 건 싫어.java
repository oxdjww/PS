import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] dup = new int[100_001];
        Arrays.fill(dup, 0);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        int left = 0, right = 0;
        while (right < N) {
            int value = arr[right];
            dup[value]++;

            while (dup[value] > K) {
                dup[arr[left]]--;
                left++;
            }

            answer = Math.max(answer, right - left + 1);
            right++;
        }
        System.out.println(answer);
    }
}