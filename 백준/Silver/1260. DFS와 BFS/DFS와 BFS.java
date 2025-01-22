import java.io.*;
import java.util.*;

class Main{
    // for dfs
    private static Map<Integer, List<Integer>> edges = new HashMap<>();
    private static Set<Integer> visited = new HashSet<>();

    // for bfs
    private static int N;
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        int V = Integer.parseInt(st1.nextToken());
        
        for(int i = 0 ; i < M ; i++)
        {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            edges.putIfAbsent(start, new ArrayList<>());
            edges.putIfAbsent(end, new ArrayList<>());
            edges.get(start).add(end);
            edges.get(end).add(start);
            Collections.sort(edges.get(start));
            Collections.sort(edges.get(end));
        }
        dfs(V);
        System.out.println();

        visited = new HashSet<>();
        bfs(V);
        System.out.println();
    }
    
    private static void dfs(int V)
    {
        visited.add(V);
        System.out.print(V + " ");
        for(int edge : edges.getOrDefault(V, new ArrayList<>()))
        {
            if(!visited.contains(edge)) dfs(edge);
        }
    }

    private static void bfs(int V)
    {
        System.out.print(V + " ");
        visited.add(V);
        queue.add(V);
        
        while(visited.size() < N && !queue.isEmpty())
        {
            int currentEdge = queue.poll();
            if(!visited.contains(currentEdge)) System.out.print(currentEdge + " ");
            visited.add(currentEdge);

            for(int edge : edges.getOrDefault(currentEdge, new ArrayList<>()))
            {
                if(!visited.contains(edge))
                {
                    queue.add(edge);
                }
            }
        }
    }
}