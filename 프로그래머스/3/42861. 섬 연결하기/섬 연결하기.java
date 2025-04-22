import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int count = 0;
        
        // 자기 자신 부모로 설정
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        
        //크루스칼 위해 최소비용으로 정렬
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        for(int[] c: costs) {
            int a = c[0];
            int b = c[1];
            int cost = c[2];
            
            if(find(parent, a) != find(parent, b)) {
                union(parent, a, b);
                answer += cost;
                count++;
                if(count == n-1) break;
            }
        }
        
        return answer;
    }
    
    private static int find(int[] parent, int index) {
        if(parent[index] == index) return index;
        return parent[index] = find(parent, parent[index]);
    }
    
    private static void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        if (rootA != rootB) parent[rootB] = rootA;
    }
}