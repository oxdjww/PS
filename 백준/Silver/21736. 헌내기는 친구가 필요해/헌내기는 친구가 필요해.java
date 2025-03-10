import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static Queue<Point> queue = new LinkedList<>();
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[] start = new int[2];

        char[][] map = new char[row][col];
        boolean[][] visited = new boolean[row][col];
        for(int i = 0 ; i < row ; i++)
        {
            char[] line = br.readLine().toCharArray();
            for(int j = 0 ; j < col ; j++)
            {
                if(line[j] == 'I')
                {
                    start[0] = i;
                    start[1] = j;
                }
                map[i][j] = line[j];
            }
        }

        int count = 0;

        queue.offer(new Point(start[0], start[1]));
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty())
        {
            Point cur = queue.poll();
            
            if(map[cur.x][cur.y] == 'P')
            {
                count++;
            }

            for(int i = 0 ; i < 4 ; i++)
            {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx >= 0 && nx < row && ny >= 0 && ny < col && map[nx][ny] != 'X' && !visited[nx][ny])
                {
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        System.out.print(count == 0 ? "TT" : count);
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