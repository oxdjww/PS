import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int[][] map;
    static int N;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new int[N][N];
        graph = new ArrayList<>(N);
        for(int i = 0; i < N; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)
                    graph.get(i).add(j);
            }
        }

        for(int i = 0; i < N; i++)
        {
            visited = new boolean[N];
            bfs(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs(int source) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        while(!queue.isEmpty())
        {
            int current = queue.poll();
            for(int destination : graph.get(current))
            {
                if(!visited[destination]) {
                    visited[destination] = true;
                    map[source][destination] = 1;
                    queue.offer(destination);
                }
            }
        }
    }
}
