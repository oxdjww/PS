import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[]arr = new int[5];
        int sum = 0;
        for(int i = 0 ; i < 5 ; i++)
        {
            int value = Integer.parseInt(br.readLine());
            sum += value;
            arr[i] = value;
        }
        Arrays.sort(arr);
        System.out.print((sum/5) + "\n" + arr[2]);
    }
}