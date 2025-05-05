import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        int answerLeft = 0;
        int answerRight = 0;
        int answer = Integer.MAX_VALUE;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(0 - answer) > Math.abs(0 - sum)) {
                answerLeft = left;
                answerRight = right;
                answer = sum;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        bw.write(String.valueOf(arr[answerLeft]) + " " + String.valueOf(arr[answerRight]));
        bw.flush();
        bw.close();
    }
}
