import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        Queue<long[]> queue = new ArrayDeque<>();
        queue.offer(new long[] { A, 1 });

        while (!queue.isEmpty()) {
            long[] current = queue.poll();
            long value = current[0];
            long count = current[1];

            if (value == B) {
                System.out.println(count);
                return;
            }

            long case1 = value * 2;
            long case2 = value * 10 + 1;

            if (case1 <= B) {
                queue.offer(new long[] { case1, count + 1 });
            }

            if (case2 <= B) {
                queue.offer(new long[] { case2, count + 1 });
            }
        }

        System.out.println(-1);
    }
}
