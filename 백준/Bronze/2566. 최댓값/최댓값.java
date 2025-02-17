import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long[][] board = new long[10][10];
        long max = 0;
        long maxRow = 1, maxCol = 1;
        
        for(int row = 1 ; row < board.length ; row++)
        {
            st = new StringTokenizer(br.readLine());
            for(int col = 1 ; col < board[row].length ; col++)
            {
                board[row][col] = Long.parseLong(st.nextToken());
                if(board[row][col] > max)
                {
                    max = board[row][col];
                    maxRow = row;
                    maxCol = col;
                }
            }
        }
        System.out.println(max);
        System.out.println(maxRow + " " + maxCol);
    }
}
