import java.io.*;
import java.util.*;

public class Main {

    private static int N, M, count;
    private static boolean[][] visited;
    private static int[][] map;
    private static Queue<Point> queue = new LinkedList<>();
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1 ,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0 ; i < N ; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++)
            {
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        count = 0;
        for(int i = 0 ; i < N ; i++)
        {
            for(int j = 0 ; j < M ; j++)
            {
                if(map[i][j] > 0 && !visited[i][j])
                {
                    countDfs(i,j);
                    count++;
                }
            }
        }
        
        if(count >= 2)
        {
            System.out.println(0);
            return;
        }

        for(int i = 0 ; i < N ; i++)
        {
            for(int j = 0 ; j < M ; j++)
            {
                if(map[i][j] > 0)
                {
                    queue.offer(new Point(i,j));
                }
            }
        }

        int year = 0;
        while(!queue.isEmpty())
        {
            year++;
            int size = queue.size();

            int[][] copy = new int[map.length][];
            for (int i = 0; i < map.length; i++) {
                copy[i] = Arrays.copyOf(map[i], map[i].length);
            }

            for(int i = 0 ; i < size ; i++)
            {
                Point cur = queue.poll();
                int near = 0;
                
                for(int j = 0 ; j < 4 ; j++)
                {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if(nx >= 0 && nx < N && ny >= 0 && ny < M && copy[nx][ny] == 0)
                    {
                        near++;
                    }
                }
                map[cur.x][cur.y] -= near;
                if(map[cur.x][cur.y] < 0) map[cur.x][cur.y] = 0;
                
                if(map[cur.x][cur.y] > 0)
                {
                    queue.offer(new Point(cur.x, cur.y));
                }
            }
            count = 0;
            visited = new boolean[N][M];
            for(int j = 0 ; j < N ; j++)
            {
                for(int k = 0 ; k < M ; k++)
                {
                    if(map[j][k] > 0 && !visited[j][k])
                    {
                        countDfs(j,k);
                        count++;
                    }
                }
            }

            if(count >= 2)
            {
                System.out.println(year);
                return;
            }
        }

        System.out.println(0);
    }

    private static void countDfs(int x, int y)
    {
        visited[x][y] = true;
        for(int i = 0 ; i < 4 ; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] > 0 && !visited[nx][ny])
            {
                countDfs(nx, ny);
            }
        }
    }
}

class Point {
    int x, y;
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}