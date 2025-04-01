import java.util.*;
import java.io.*;

public class Main {
    private static int q = 25;
    private static int d = 10;
    private static int n = 5;
    private static int p = 1;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int change = Integer.parseInt(st.nextToken());
            sb.append(change/q).append(" ");
            change %= q;
            sb.append(change/d).append(" ");
            change %= d;
            sb.append(change/n).append(" ");
            change %= n;
            sb.append(change).append("\n");
        }
        System.out.print(sb);
    }
}