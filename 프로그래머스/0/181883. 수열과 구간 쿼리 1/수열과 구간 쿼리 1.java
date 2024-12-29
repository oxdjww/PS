import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int i = 0 ; i < queries.length ; i++)
        {
            int s = queries[i][0];
            int e = queries[i][1];
            IntStream.rangeClosed(s, e)
                .forEach(idx -> arr[idx]++);
        }
        return arr;
    }
}