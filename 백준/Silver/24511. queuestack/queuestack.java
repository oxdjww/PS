import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < N ; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
        {
            int element = Integer.parseInt(st.nextToken());
            if (arr[i] == 0)
            {
                queue.offerFirst(element);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < M ; i++)
        {
            int element = Integer.parseInt(st.nextToken());
            queue.offer(element);
            element = queue.poll();
            if(i != M-1) sb.append(element + " ");
            else sb.append(element+"\n");
        }
        System.out.print(sb.toString());
    }
}