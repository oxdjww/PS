class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int val = 1;
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        while(val <= n * n)
        {
            for(int i = rowStart ; i <= rowEnd ; i++)
            {
                answer[colStart][i] = val;
                val++;
            }
            colStart++;
            for(int i = colStart ; i <= colEnd ; i++)
            {
                answer[i][rowEnd] = val;
                val++;
            }
            rowEnd--;
            for(int i = rowEnd ; i >= rowStart ; i--)
            {
                answer[colEnd][i] = val;
                val++;
            }
            colEnd--;
            for(int i = colEnd ; i >= colStart ; i--)
            {
                answer[i][rowStart] = val;
                val++;
            }
            rowStart++;
        }
        return answer;
    }
}