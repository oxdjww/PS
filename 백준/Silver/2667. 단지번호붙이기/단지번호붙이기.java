import java.io.*;
import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1 ,1, 0, 0};
    private static int[] dy = {0, 0, -1 ,1};
    private static List<Integer> answer = new ArrayList<>();
    private static int N;

    public static void main(String[] args) {
        N = scanner.nextInt();
        scanner.nextLine();
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for(int[] row: map)
        {
            String str = scanner.nextLine();
            for(int i = 0 ; i < row.length ; i++)
            {
                row[i] = str.charAt(i) - '0';
            }
        }

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++){
                if (map[i][j] == 1 && !visited[i][j])
                {
                    answer.add(bfs(i, j));
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (int size : answer) {
            System.out.println(size);
        }
    }
    private static int bfs(int x, int y)
    {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;
        int size = 0;

        while (!queue.isEmpty())
        {
            Point cur = queue.poll();
            size++;

            for (int i = 0; i < 4; i++)
            {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == 1)
                {
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        return size;
    }
}

class Point{
    int x;
    int y;
    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}