import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodeNums = scanner.nextInt();
        int edgeNums = scanner.nextInt();
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= nodeNums; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edgeNums; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[nodeNums + 1];
        
        queue.offer(1);
        visited[1] = true;
        
        int infectCount = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            infectCount++;
            
            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        
        System.out.println(infectCount - 1);
    }
}
