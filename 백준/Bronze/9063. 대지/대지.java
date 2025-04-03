import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long xMax = Long.MIN_VALUE;
        long xMin = Long.MAX_VALUE;
        long yMax = Long.MIN_VALUE;
        long yMin = Long.MAX_VALUE;
        for(int i = 0 ; i < n ; i++)
        {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            xMax = Math.max(xMax, x);
            xMin = Math.min(xMin, x);
            yMax = Math.max(yMax, y);
            yMin = Math.min(yMin, y);
        }
        System.out.print((xMax - xMin) * (yMax - yMin));
    }
}

