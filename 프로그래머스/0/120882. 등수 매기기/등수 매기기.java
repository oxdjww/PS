import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        int[] array = new int[score.length];
        Arrays.fill(array, 1);

        for(int i = 0 ; i < score.length ; i++)
        {
            for(int j = 0 ; j < score.length ; j++)
                if ((score[i][0] + score[i][1]) < (score[j][0] + score[j][1]))
                    array[i]++;
        }
        return array;
    }
}