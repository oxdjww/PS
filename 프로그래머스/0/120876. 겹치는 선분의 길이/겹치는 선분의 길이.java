import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        int[] answer = new int[200];
        for(int i = 0 ; i < lines.length ; i++)
        {
            for(int idx = lines[i][0]+100 ; idx < lines[i][1]+100 ; idx++)
            {
                answer[idx]++;
            }
        }
        int count = 0;
        for(int i = 0 ; i < answer.length ; i++)
        {
            if(answer[i] >= 2)
                count++;
        }
        return count;
    }
}