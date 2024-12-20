class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int i = 0 ; i < queries.length ; i++)
        {
            int start = queries[i][0];
            int end = queries[i][1];
            int k = queries[i][2];
            for(int t = start ; t <= end ; t++)
            {
                arr[t] += t%k == 0 ? 1 : 0;
            }
        }
        return arr;
    }
}