import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        List<Integer> answer = new ArrayList();
        for(int i = 0 ; i < queries.length ; i++)
        {
            int MIN = Integer.MAX_VALUE;
            int start = queries[i][0];
            int end = queries[i][1];
            int atLeast = queries[i][2];
            int ans = -1;
            for(int k = start ; k <= end ; k++)
            {
                if(arr[k] > atLeast && arr[k] < MIN)
                {
                    ans = arr[k];
                    MIN = arr[k];
                }                    
            }
            answer.add(ans);
        }
        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}