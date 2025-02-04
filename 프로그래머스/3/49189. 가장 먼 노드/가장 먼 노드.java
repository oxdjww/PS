import java.util.*;
class Solution {
    private static HashMap<Integer, Integer> graph = new HashMap<>();
    private static int[] nodes;
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] distance = new int[n+1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        Arrays.fill(distance, -1);
        
        queue.offer(1);
        distance[1] = 0;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);
                }
            }
        }
        
        int maxDist = Arrays.stream(distance).max().getAsInt();
        int count = 0;
        for (int d : distance) {
            if (d == maxDist) count++;
        }
        
        return count;
    }
}