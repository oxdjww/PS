import java.util.stream.*;
import java.util.*;
class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for(String str : s1)
        {
            if(Arrays.stream(s2).collect(Collectors.toList()).contains(str))
                answer++;
        }
        return answer;
    }
}