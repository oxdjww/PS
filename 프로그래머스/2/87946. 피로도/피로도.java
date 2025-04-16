import java.util.*;

class Solution {
    
    private int[][] stages;
    private List<Integer> answer = new ArrayList<>();
    private boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        stages = dungeons;
        visited = new boolean[dungeons.length];

        dfs(k, 0);
        
        return Collections.max(answer);
    }
    
    private void dfs(int currentPower, int depth) {
        if(depth == stages.length) {
            answer.add(depth);
            // System.out.println("DEPTH");
            return;
        }
                
        int result = 0;
        for(int nextStage = 0; nextStage < stages.length; nextStage++) {
            if(!visited[nextStage] && currentPower >= stages[nextStage][0]) {
                visited[nextStage] = true;
                dfs(currentPower - stages[nextStage][1], depth + 1);
                visited[nextStage] = false;
            }
        }
        // System.out.println("END");
        answer.add(depth);
        return;
    }
}