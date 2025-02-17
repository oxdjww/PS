import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Deque<Integer> queue = new ArrayDeque<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++)
        {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;
            queue.offer(i);
        }
        
        int value = 1;
        while(!queue.isEmpty())
        {
            int number = value > 0 ? queue.pollFirst() : queue.pollLast();
            System.out.print(number + " ");
            
            value = arr[number];
            
            if(value > 0 && !queue.isEmpty())
            {
                for(int i = 0 ; i < value - 1 ; i++)
                {
                    if(!queue.isEmpty())
                        queue.offerLast(queue.pollFirst());
                }
            }
            else
            {
                for(int i = 0 ; i < -value - 1 ; i++)
                {
                    if(!queue.isEmpty())
                        queue.offerFirst(queue.pollLast());
                }
            }
        }
    }
}