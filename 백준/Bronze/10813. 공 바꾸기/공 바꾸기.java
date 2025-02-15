import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N+1];
        for(int n = 1 ; n < N+1 ; n++)
        {
            arr[n] = n;
        }

        for(int m = 0 ; m < M ; m++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

        for(int i = 1 ; i < arr.length ; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}