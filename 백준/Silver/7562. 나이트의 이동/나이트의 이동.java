import java.io.*;
import java.util.*;

public class Main {
    private static int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };
    private static int[] dy = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testcase; t++) {
            int l = Integer.parseInt(br.readLine());
            visited = new boolean[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int src_x = Integer.parseInt(st.nextToken());
            int src_y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int dst_x = Integer.parseInt(st.nextToken());
            int dst_y = Integer.parseInt(st.nextToken());

            if (src_x == dst_x && src_y == dst_y) {
                sb.append(0).append("\n");
                continue;
            }

            Queue<int[]> queue = new ArrayDeque<>();

            queue.offer(new int[] { src_x, src_y, 0 });

            while (!queue.isEmpty()) {
                int[] current = queue.poll();

                int cx = current[0];
                int cy = current[1];
                int cc = current[2];

                if (cx == dst_x && cy == dst_y) {
                    sb.append(cc).append("\n");
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    if (isValidPoint(nx, ny) && !visited[nx][ny]) {
                        queue.offer(new int[] { nx, ny, cc + 1 });
                        visited[nx][ny] = true;
                    }
                }
            }

        }

        System.out.println(sb.toString());
    }

    private static boolean isValidPoint(int x, int y) {
        return x >= 0 && y >= 0 && x < visited.length && y < visited.length;
    }
}
