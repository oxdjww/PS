class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visit = new boolean[n];
        int answer = 0;
        for(int i = 0 ; i < n ; i++)
        {
            if(!visit[i])
            {
                dfs(n, computers, visit, i);
                answer++;
            }
        }
        return answer;
    }
    private void dfs(int n, int[][] computers, boolean[] visit, int i)
    {
        visit[i] = true;
        for(int j = 0 ; j < computers[i].length ; j++)
        {
            if(!visit[j] && computers[i][j] == 1)
            {
                dfs(n, computers, visit, j);
            }
        }
    }
}