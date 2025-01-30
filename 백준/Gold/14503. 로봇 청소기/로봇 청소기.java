import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, R, C, D;
    private static int[][] map;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int n = 0; n < N; n++)
        {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++)
            {
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(R, C, D);
        System.out.println(count);
    }

    private static void dfs(int x, int y, int dir) {
        if (map[x][y] == 0)
        {
            map[x][y] = 2;
            count++;
        }

        for (int i = 0; i < 4; i++)
        {
            dir = (dir + 3) % 4;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0)
            {
                dfs(nx, ny, dir);
                return;
            }
        }

        int backDir = (dir + 2) % 4;
        int bx = x + dx[backDir];
        int by = y + dy[backDir];

        if (bx >= 0 && bx < N && by >= 0 && by < M && map[bx][by] != 1)
        {
            dfs(bx, by, dir);
        }
    }
}
