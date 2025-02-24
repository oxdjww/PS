import java.io.*;
import java.util.*;

public class Main {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0 ; i < N ; i++)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0 ; i < N-1 ; i++)
        {
            for(int j = i ; j < N ; j++)
            {
                if(arr[i] > arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++)
        {
            sb.append(arr[i] + "\n");
        }
        System.out.print(sb);
    }
}