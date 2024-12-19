import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        List<Integer> arr = IntStream.range(0, included.length)
            .filter(i -> included[i])
            .boxed()
            .collect(Collectors.toList());
        for(Integer idx : arr)
        {
            answer += (a + idx * d);
        }
        
        return answer;
    }
}