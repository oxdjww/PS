import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        
        for (int i = 0; i < M; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int minKevinBacon = Integer.MAX_VALUE;
        int answer = -1;
        
        for (int i = 1; i <= N; i++) {
            int kevinBacon = bfs(i);
            if (kevinBacon < minKevinBacon) {
                minKevinBacon = kevinBacon;
                answer = i;
            }
        }
        
        
        System.out.println(answer);
    }
    
    public static int bfs(int start) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(start);
        distance[start] = 0;
        
        while (!queue.isEmpty())
        {
            int current = queue.poll();
            for (int next : graph[current])
            {
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }

        int totalDistance = 0;
        for (int i = 1; i <= N; i++)
        {
            totalDistance += distance[i];
        }
        return totalDistance;
    }
}
