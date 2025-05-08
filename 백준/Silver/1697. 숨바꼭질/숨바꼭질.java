import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] { N, 0 });
        boolean[] visited = new boolean[100_001];
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int location = current[0];
            int time = current[1];

            if (location == K) {
                System.out.println(time);
                return;
            }
            int nt = time + 1;
            if (isValid(location + 1) && !visited[location + 1]) {
                queue.offer(new int[] { location + 1, nt });
                visited[location + 1] = true;
            }
            if (isValid(location - 1) && !visited[location - 1]) {
                queue.offer(new int[] { location - 1, nt });
                visited[location - 1] = true;
            }
            if (isValid(location * 2) && !visited[location * 2]) {
                queue.offer(new int[] { location * 2, nt });
                visited[location * 2] = true;
            }
        }
    }

    private static boolean isValid(int location) {
        return location >= 0 && location <= 100_000;
    }
}