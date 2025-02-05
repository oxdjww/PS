import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static long M;
    private static long[][] subSumArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        subSumArray = new long[N+1][N+1];
        
        for(int n = 1 ; n <= N ; n++){
            st = new StringTokenizer(br.readLine());
            for(int nn = 1 ; nn <= N ; nn++){
                subSumArray[n][nn] = subSumArray[n-1][nn] + subSumArray[n][nn-1] - subSumArray[n-1][nn-1] + Long.parseLong(st.nextToken());
            }
        }

        for(int m = 0 ; m < M ; m++){
            st = new StringTokenizer(br.readLine());
            int startRow = Integer.parseInt(st.nextToken());
            int startCol = Integer.parseInt(st.nextToken());
            int endRow = Integer.parseInt(st.nextToken());
            int endCol = Integer.parseInt(st.nextToken());
            System.out.println(subSumArray[endRow][endCol] - subSumArray[endRow][startCol-1] - subSumArray[startRow-1][endCol] + subSumArray[startRow-1][startCol-1]);
        }
    }
} 