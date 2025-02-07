import java.io.*;
import java.util.*;

public class Main {
    private static int rowNums, colNums;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] answer;
    private static Queue<Point> queue = new LinkedList<>();
    private static int[] dx = {-1 ,1 ,0 ,0};
    private static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rowNums = Integer.parseInt(st.nextToken());
        colNums = Integer.parseInt(st.nextToken());

        map = new int[rowNums][colNums];
        answer = new int[rowNums][colNums];
        visited = new boolean[rowNums][colNums];
        
        int targetRow=0, targetColumn=0;
        for(int i = 0 ; i < rowNums ; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < colNums ; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2)
                {
                    targetRow = i;
                    targetColumn = j;
                }
            }
        }
    

        queue.offer(new Point(targetRow, targetColumn, 0));

        while(!queue.isEmpty())
        {
            Point cur = queue.poll();

            answer[cur.row][cur.column] = cur.distance;

            for(int i = 0 ; i < 4 ; i++)
            {
                int nrow = cur.row + dx[i];
                int ncol = cur.column + dy[i];
                
                if(nrow < 0 || nrow >= rowNums || ncol < 0 || ncol >= colNums || visited[nrow][ncol] || map[nrow][ncol] == 0)
                    continue;
                
                visited[nrow][ncol] = true;
                queue.offer(new Point(nrow, ncol, cur.distance+1));
            }
        }
        for(int i = 0 ; i < rowNums ; i++)
        {
            for(int j = 0 ; j < colNums ; j++)
            {
                if(answer[i][j] == 0 && map[i][j] == 1)
                {
                    System.out.print("-1 ");
                }
                else if(i == targetRow && j == targetColumn)
                {
                    System.out.print("0 ");
                }
                else
                {
                    System.out.print(answer[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

class Point{
    int row, column;
    int distance;
    
    public Point(int row, int column, int distance)
    {
        this.row = row;
        this.column = column;
        this.distance = distance;
    }
}