import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[1001];
        int maxHeight = 0;
        int maxHeightLocation = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int location = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            // System.out.println("loc: " + location + "\n height: " + height);
            arr[location] = height;
            if (maxHeight < height) {
                maxHeight = height;
                maxHeightLocation = location;
            }
        }
        // System.out.println("MAX: " + max);

        int answer = 0;
        int height = 0;
        for (int i = 0; i < maxHeightLocation; i++) {
            // System.out.println(height);
            height = Math.max(height, arr[i]);
            answer += height;
        }
        height = 0;
        for (int i = arr.length - 1; i >= maxHeightLocation; i--) {
            // System.out.println(height);
            height = Math.max(height, arr[i]);
            answer += height;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}