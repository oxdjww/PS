import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static long M;
    private static long[] subSumArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        subSumArray = new long[N+1];
        
        st = new StringTokenizer(br.readLine());
        for(int n = 1 ; n <= N ; n++){
            subSumArray[n] = subSumArray[n-1] + Long.parseLong(st.nextToken());
        }
        
        for(int m = 0 ; m < M ; m++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(subSumArray[end] - subSumArray[start-1]);
        }
    }
}