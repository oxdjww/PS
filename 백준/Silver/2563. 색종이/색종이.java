import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] board = new int[101][101];

        int iter = Integer.parseInt(st.nextToken());
        for(int i = 0; i < iter; i++)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int dx = x; dx < x + 10; dx++)
            {
                for(int dy = y; dy < y + 10; dy++) board[dy][dx] = 1;
            }
        }

        int count = 0;
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                if(board[i][j] == 1) count++;
            }
        }

        System.out.println(count);
    }
}
