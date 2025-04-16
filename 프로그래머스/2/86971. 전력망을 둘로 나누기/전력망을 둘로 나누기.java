import java.util.*;

class Solution {
    
    private int answer = Integer.MAX_VALUE;
    private int totalCount;
    private List<List<Integer>> graph = new ArrayList<>();
    private boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        totalCount = n;
        visited = new boolean[n+1];
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

                
        for(int i = 0; i < wires.length; i++) {
            answer = Math.min(answer, simulate(wires[i][0], wires[i][1]));
            Arrays.fill(visited, false);
        }
        
        return answer;
    }
    
    private int simulate(int start, int end) {
        // System.out.println("REMOVE: start(" + start + "), end(" + end + ")");
        graph.get(start).remove(Integer.valueOf(end));
        graph.get(end).remove(Integer.valueOf(start));
        
        visited[1] = true;
        dfs(1, 1);
        
        graph.get(start).add(end);
        graph.get(end).add(start);
        int count = 0;
        for(int i = 0; i < visited.length; i++) {
            if(visited[i]) count++;
        }
        
        return Math.abs(totalCount - count * 2);
    }
    
    private void dfs(int current, int count) {
        visited[current] = true;
        // System.out.println("CURRENT: " + current);
        // 순회해서 한쪽만 찾기
        List<Integer> neighbors = graph.get(current);
        for(int neighbor : neighbors) {
            if(!visited[neighbor]) {
                // System.out.println("VISIT: " + neighbor);
                dfs(neighbor, count + 1);
                // System.out.println("COUNT: " + count );
            }
        }
        // return count;
    }
}