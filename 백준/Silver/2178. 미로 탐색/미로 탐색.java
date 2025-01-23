import java.io.*;
import java.util.*;

public class Main {
    private static Queue<Point> queue = new LinkedList<>();
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        bfs(0,0);
    }

    private static void bfs(int startX, int startY)
    {
        queue.offer(new Point(startX, startY, 1));
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if(cur.x == N-1 && cur.y == M-1)
            {
                System.out.println(cur.dist);
                return;
            }
            for(int i = 0 ; i < 4 ; i++)
            {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                // System.out.println(nx + " " + ny);
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 1 && !visited[nx][ny])
                {
                    queue.offer(new Point(nx, ny, cur.dist+1));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}

class Point {
    public int x;
    public int y;
    public int dist;

    public Point(int x, int y, int dist)
    {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}