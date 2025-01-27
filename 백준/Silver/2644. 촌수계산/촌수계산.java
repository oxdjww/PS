import java.io.*;
import java.util.*;

public class Main {

    private static int N, a, b, M;
    private static Map<Integer, List<Integer>> edges = new HashMap<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.valueOf(st.nextToken());
        b = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(br.readLine());

        for(int i = 0 ; i < M ; i++)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());

            edges.putIfAbsent(x, new ArrayList<>());
            edges.putIfAbsent(y, new ArrayList<>());
            edges.get(x).add(y);
            edges.get(y).add(x);
        }
        visited = new boolean[N + 1];
        System.out.println(dfs(a,b,0));
    }
    private static int dfs(int a, int b, int depth)
    {
        if(a == b) return depth;
        visited[a] = true;
        for (int edge : edges.getOrDefault(a, Collections.emptyList()))
        {
            if(!visited[edge])
            {
                int result = dfs(edge, b, depth + 1);
                if (result != -1) return result;
            }
        }
        return -1;
    }
}