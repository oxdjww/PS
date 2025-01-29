import java.io.*;
import java.util.*;

public class Main {

    private static int T, N;
    private static int[] src = new int[2], dst = new int[2];
    private static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.valueOf(st.nextToken());

        for(int t = 0 ; t < T ; t++)
        {
            List<int[]> conv = new ArrayList<>();
            boolean flag = false;
            Queue<int[]> queue = new LinkedList<>();
         
            st = new StringTokenizer(br.readLine());
            N = Integer.valueOf(st.nextToken());

            visited = new boolean[N];

            st = new StringTokenizer(br.readLine());
            src[0] = Integer.valueOf(st.nextToken());
            src[1] = Integer.valueOf(st.nextToken());
            
            for(int n = 0 ; n < N ; n++)
            {
                st = new StringTokenizer(br.readLine());
                int convx= Integer.valueOf(st.nextToken());
                int convy = Integer.valueOf(st.nextToken());
                conv.add(new int[]{convx, convy});
            }

            st = new StringTokenizer(br.readLine());
            dst[0] = Integer.valueOf(st.nextToken());
            dst[1] = Integer.valueOf(st.nextToken());

            queue.offer(src);
            
            while(!queue.isEmpty())
            {
                int[] cur = queue.poll();

                if(canReach(cur, dst))
                {
                    flag = true;
                    break;
                }
                else
                {
                    for(int n = 0 ; n < N ; n++)
                    {
                        if(canReach(cur, conv.get(n)) && !visited[n])
                        {
                            queue.offer(conv.get(n));
                            visited[n] = true;
                        }
                    }
                }
            }
            System.out.println(flag ? "happy" : "sad");
        }
    }
    private static boolean canReach(int[] src, int[] dst)
    {
        return (Math.abs(src[0] - dst[0]) + Math.abs(src[1] - dst[1])) <= 1000 ? true : false;
    }
}
