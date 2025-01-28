import java.io.*;
import java.util.*;

public class Main {

    private static int N, K;
    private static int nx1, nx2, nx3;
    private static boolean[] visited = new boolean[100001];
    private static Queue<Integer> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());
        
        if(N == K)
        {
            System.out.println(0);
            return;
        }
    
        nx1 = N-1;
        nx2 = N+1;
        nx3 = N*2;
        if(nx1 >= 0 && nx1 <= 100000) queue.offer(nx1);
        if(nx2 >= 0 && nx2 <= 100000) queue.offer(nx2);
        if(nx3 >= 0 && nx3 <= 100000) queue.offer(nx3);

        int time = 0;
        int target = K;

        while(true)
        {
            time++;

            int size = queue.size();
            for(int i = 0 ; i < size ; i++)
            {
                int cur = queue.poll();
                visited[cur] = true;
                if(cur == target)
                {
                    System.out.println(time);
                    return;
                }

                nx1 = cur-1;
                nx2 = cur+1;
                nx3 = cur*2;
                    
                if(nx1 >= 0 && nx1 <= 100000 && !visited[nx1]) queue.offer(nx1);
                if(nx2 >= 0 && nx2 <= 100000 && !visited[nx2]) queue.offer(nx2);
                if(nx3 >= 0 && nx3 <= 100000 && !visited[nx3]) queue.offer(nx3);
            }            
        }
    }
}