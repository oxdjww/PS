import java.util.*;
import java.util.stream.*;
import java.math.*;
class Solution {
    public int[] solution(int[] emergency) {
        List<Integer> list = Arrays.stream(emergency)
            .boxed()
            .collect(Collectors.toList());
        for(int i = 1 ; i <= list.size() ; i++)
        {
            int maxVal = Collections.max(list);
            list.set(list.indexOf(maxVal), 0 - i);
        }
        return list.stream()
            .map(idx -> Math.abs(idx))
            .mapToInt(Integer::intValue)
            .toArray();
    }
}