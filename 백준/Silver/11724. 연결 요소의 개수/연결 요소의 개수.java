import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] visited;
    private static int count = 0;
    private static HashMap<Integer, List<Integer>> edges = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int nodeNum = Integer.parseInt(st.nextToken());
        visited = new boolean[nodeNum+1];
        int edgeNum = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < edgeNum ; i++)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            edges.computeIfAbsent(start, k -> new ArrayList<>()).add(end);
            edges.computeIfAbsent(end, k ->new ArrayList<>()).add(start);
        }
        for(int i = 1 ; i <= nodeNum ; i++)
        {
            if(!visited[i])
            {
                count++;
                dfs(i);
            }
        }
        System.out.print(count);
    }
    private static void dfs(int start)
    {
        visited[start] = true;
        for(int node: edges.getOrDefault(start, new ArrayList<>()))
        {
            if(!visited[node]) dfs(node);
        }
    }
}