import java.math.*;
class Solution {
    public int[][] solution(int[][] arr) {
        int size = Math.max(arr.length,arr[0].length);
        int[][] answer = new int[size][size];
        for(int i = 0 ; i < answer.length ; i++)
        {
            for(int j = 0 ; j < answer[i].length ; j++)
            {
                if(i < arr.length && j < arr[0].length)
                    answer[i][j] = arr[i][j];
            }
        }
        return answer;
    }
}