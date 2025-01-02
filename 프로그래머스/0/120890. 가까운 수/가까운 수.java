import java.math.*;
import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        Arrays.sort(array);
        int answer = 0;
        int diff = 0xff;
        for(int val : array)
        {
            if(Math.abs(val - n) < diff)
            {
                answer = val;
                diff = Math.abs(val - n);
            }
        }
        return answer;
    }
}