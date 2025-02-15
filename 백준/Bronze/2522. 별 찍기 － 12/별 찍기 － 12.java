import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String star = "*";
        String blank = " ";
        for(int i = 1 ; i <= N ; i++)
        {
            System.out.print(blank.repeat(N-i));
            System.out.print(star.repeat(i));
            System.out.println();
        }
        for(int i = N-1 ; i > 0 ; i--)
        {
            System.out.print(blank.repeat(N-i));
            System.out.print(star.repeat(i));
            System.out.println();
        }
    }
}