import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int current = 0;
        for (int i = 0; i < x; i++) {
            current += arr[i];
        }
        List<Integer> count = new ArrayList<>();

        count.add(current);

        int left = 0, right = x;
        int answer = current;
        for (int i = right; i < n; i++) {
            current += arr[i];
            current -= arr[left];
            if (current > answer) {
                answer = current;
            }
            count.add(current);

            left++;
        }
        if (answer != 0) {
            System.out.println(answer);
            int tmp = 0;
            for (int index : count) {
                if (index == answer) {
                    tmp++;
                }
            }
            System.out.println(tmp);
        } else {
            System.out.println("SAD");
        }
    }
}
