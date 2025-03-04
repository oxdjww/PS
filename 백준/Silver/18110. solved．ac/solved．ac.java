import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        double sum = 0;
        int k = (int)Math.round(N * 0.15);
        for(int i = k ; i < N - k ; i++)
        {
            sum += arr[i];
        }
        System.out.println(Math.round(sum / (double)(N - k * 2)));
    }
}