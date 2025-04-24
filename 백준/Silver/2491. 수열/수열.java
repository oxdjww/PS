import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 증가 구간 길이, 감소 구간 길이 추적 변수
        int inc_len = 1;
        int dec_len = 1;

        // 최대 길이 기록 변수
        int max_len = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                // 증가 구간
                inc_len++;
            } else {
                // 증가 구간 종료, 최대 길이 갱신
                max_len = Math.max(max_len, inc_len);
                inc_len = 1; // 증가 구간 리셋
            }

            if (arr[i] <= arr[i - 1]) {
                // 감소 구간
                dec_len++;
            } else {
                // 감소 구간 종료, 최대 길이 갱신
                max_len = Math.max(max_len, dec_len);
                dec_len = 1; // 감소 구간 리셋
            }
        }
        
        max_len = Math.max(max_len, inc_len);
        max_len = Math.max(max_len, dec_len);

        System.out.println(max_len);
    }
}
