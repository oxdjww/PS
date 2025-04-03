import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[3];
        arr[0] = Long.parseLong(st.nextToken());
        arr[1] = Long.parseLong(st.nextToken());
        arr[2] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);
        if(arr[0] + arr[1] > arr[2]) {
            System.out.print(arr[0] + arr[1] + arr[2]);
            return;
        } else {
            arr[2] = arr[0]+arr[1]-1;
            System.out.print(arr[0] + arr[1] + arr[2]);
            return;
        }
    }
}