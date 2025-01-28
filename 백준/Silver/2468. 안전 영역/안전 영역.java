import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    private static int N;
    private static boolean[][] visited;
    private static int[][] map;
    private static Queue<Integer> queue = new LinkedList<>();
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1 ,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        map = new int[N][N];

        for(int i = 0 ; i < N ; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++)
            {
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        
        int safeMax = 1;
        for(int danger = 1 ; danger <= 100 ; danger++)
        {
            visited = new boolean[N][N];
            int count = 0;
            for(int x = 0 ; x < N ; x++)
            {
                for(int y = 0 ; y < N ; y++)
                {
                    if(!visited[x][y] && map[x][y] > danger)
                    {
                        dfs(x,y, danger);
                        count++;
                    }
                }
            }
            safeMax = Math.max(safeMax, count);
        }
        System.out.println(safeMax);
    }
    private static void dfs(int x, int y, int danger)
    {
        visited[x][y] = true;

        for(int i = 0 ; i < 4 ; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N  && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] > danger)
            {
                dfs(nx, ny, danger);
            }
        }
    }
}