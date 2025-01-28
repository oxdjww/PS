import java.io.*;
import java.util.*;

public class Main {

    private static int totalHeight, cur, office, up, down;
    private static boolean[] visited;
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        totalHeight= Integer.valueOf(st.nextToken());
        cur = Integer.valueOf(st.nextToken());
        office = Integer.valueOf(st.nextToken());
        up = Integer.valueOf(st.nextToken());
        down = Integer.valueOf(st.nextToken());

        visited = new boolean[totalHeight+1];

        if(office == cur)
        {
            System.out.println(0);
            return;
        }

        queue.offer(cur);

        int count = 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            count++;
            for(int i = 0 ; i < size ; i++)
            {
                cur = queue.poll();
                visited[cur] = true;

                int ucur = cur + up;
                int dcur = cur - down;
                
                if(ucur == office || dcur == office)
                {
                    System.out.println(count);
                    return;
                }

                if(ucur > 0 && ucur <= totalHeight && !visited[ucur]) 
                {
                    queue.offer(ucur);
                    visited[ucur] = true;
                }
                if(dcur > 0 && dcur <= totalHeight && !visited[dcur])
                {
                    queue.offer(dcur);
                    visited[dcur] = true;
                }
            }
        }
        System.out.println("use the stairs");
    }
}