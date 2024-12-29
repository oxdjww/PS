class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        for(int i = 0 ; i < n ; i++)
            for(int ii = 0 ; ii < n ; ii++)
            {
                if(i==ii)
                    answer[i][ii]=1;
                else answer[i][ii]=0;
            }
        return answer;
    }
}