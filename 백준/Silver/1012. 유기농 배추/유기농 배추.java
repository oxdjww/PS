import java.io.*;
import java.util.*;

public class Main {
    private static int T, M, N, K;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0 ,0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int testcase = 0 ; testcase < T ; testcase++)
        {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for(int k = 0 ; k < K ; k++)
            {
                st = new StringTokenizer(br.readLine());
                int column = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());
                map[row][column] = 1;
            }
            
            int count = 0;
            for(int n = 0 ; n < N ; n++)
            {
                for(int m = 0 ; m < M ; m++)
                {
                    if(!visited[n][m] && map[n][m] == 1)
                    {
                        dfs(n, m);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    private static void dfs(int n, int m){
        visited[n][m] = true;

        for(int i = 0 ; i < 4 ; i++)
        {
            int nx = n + dx[i];
            int ny = m + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == 0) continue;
            dfs(nx, ny);
        }
    }
} 