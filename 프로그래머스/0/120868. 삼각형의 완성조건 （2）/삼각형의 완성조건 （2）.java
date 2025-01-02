import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] sides) {
        int count = 0;
        Arrays.sort(sides);
        count += IntStream.range(sides[1], sides[0] + sides[1])
            .count();
        for(int i = 0 ; i < sides[1] ; i++)
        {
            if(i + sides[0] > sides[1])
                count++;
        }
        return count;
    }
}