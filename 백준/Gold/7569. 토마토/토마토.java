import java.io.*;
import java.util.*;

public class Main {

    private static int M, N, H;
    private static int[][][] map;
    private static boolean[][][] visited;
    private static Queue<Tomato> queue = new LinkedList<>();
    private static int dx[] = {1,0,-1,0,0,0};
    private static int dy[] = {0,1,0,-1,0,0};
    private static int dz[] = {0,0,0,0,1,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.valueOf(st.nextToken());
        N = Integer.valueOf(st.nextToken());
        H = Integer.valueOf(st.nextToken());

        map = new int[H][N][M];
        visited = new boolean[H][N][M];
        int totalTomatoCount = 0;
        int goodTomatoCount = 0;

        for (int h = 0; h < H; h++)
        {
            for (int n = 0; n < N; n++)
            {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++)
                {
                    map[h][n][m] = Integer.parseInt(st.nextToken());
                    if(map[h][n][m] != -1) totalTomatoCount++;
                    if(map[h][n][m] == 1)
                    {
                        goodTomatoCount++;
                        queue.offer(new Tomato(m, n, h));
                        visited[h][n][m] = true;
                    }
                }
            }
        }

        if(totalTomatoCount == goodTomatoCount)
        {
            System.out.println(0);
            return;
        }

        int days = -1;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            days++;

            for (int s = 0; s < size; s++) {
                Tomato cur = queue.poll();
                for(int i = 0 ; i < 6 ; i++)
                {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    int nz = cur.z + dz[i];

                    if(nx < 0 || ny < 0 || nz < 0) continue;
                    if(nx >= M || ny >= N || nz >= H) continue;
                    if(map[nz][ny][nx] == -1) continue;
                    if(visited[nz][ny][nx]) continue;

                    visited[nz][ny][nx] = true;
                    map[nz][ny][nx] = 1;
                    queue.offer(new Tomato(nx, ny, nz));
                }
            }
        }

        for (int h = 0; h < H; h++)
        {
            for (int n = 0; n < N; n++)
            {
                for (int m = 0; m < M; m++)
                {
                    if(map[h][n][m] == 0)
                    {
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }
        System.out.println(days);
    }
}

class Tomato {
    int x;
    int y;
    int z;
    public Tomato(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}